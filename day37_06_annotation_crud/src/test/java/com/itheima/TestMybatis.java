package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-10-29  11:13
 */
public class TestMybatis {

    private UserDao userDao;
    private SqlSession sqlSession;
    private InputStream is;

    @Before
    public void init() throws Exception {
        //1. 让mybatis框架去加载主配置文件
        //1.1 将主配置文件SqlMapConfig.xml转换成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //1.2 创建一个SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //1.3 使用factoryBuilder对象加载字节输入流，创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = factoryBuilder.build(is); //使用了构建者模式
        //1.4 使用sessionFactory对象创建出sqlSession对象
        //使用了工厂模式
        sqlSession = sessionFactory.openSession();

        //2. 使用sqlSession对象创建出UserDao接口的代理对象
        //使用了动态代理
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @Test
    public void testAddUser(){
        //3. 调用userDao对象的addUser方法添加用户
        User user = new User(null, "贾克斯", "召唤师峡谷", "女", new Date());
        //用户添加之前的id为null
        userDao.addUser(user);

        //目标是添加完用户之后，获取到该用户的id : 在以后的多表中，进行关联添加
        System.out.println(user.getUid());
    }

    @Test
    public void testDelete(){
        userDao.deleteById(27);
    }

    @Test
    public void testUpdate(){
        User user = userDao.findById(24);

        user.setUsername("圣枪游侠");
        user.setSex("男");
        user.setAddress("召唤师峡谷");

        userDao.updateUser(user);
    }
    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();

        //4. 关闭资源
        sqlSession.close();
        is.close();
    }
}
