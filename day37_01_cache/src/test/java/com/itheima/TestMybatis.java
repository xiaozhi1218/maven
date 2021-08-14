package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-10-29  12:30
 * 一级缓存是sqlSession级别的缓存，只要是同一个sqlSession对象，就能共用以及缓存内的数据
 * 什么情况下会清除一级缓存?
 * 1. sqlSession对象调用commit()方法、clearCache()方法、close()方法
 * 2. 数据发生增删改
 *
 *
 * 二级缓存是SqlSessionFactory级别的缓存，只要是由同一个SqlSessionFactory创建的SqlSession都能共用二级缓存里面的内容
 * 二级缓存的配置:
 *      1. 主配置文件中添加setting，可以省略
 *      2. 要进行二级缓存的映射配置文件中添加cache标签
 *      3. 要进行二级缓存的POJO类实现Serializable接口
 *
 * 二级缓存什么时候会清除呢?
 * 数据发生增删改
 */
public class TestMybatis {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println(userDao.findAll());

        userDao.deleteById(26);
        System.out.println("--------------------------------------");

        System.out.println(userDao.findAll());

        sqlSession.commit();
    }

    @Test
    public void test02(){
        SqlSession sqlSession1 = SqlSessionFactoryUtil.openSqlSession();
        SqlSession sqlSession2 = SqlSessionFactoryUtil.openSqlSession();
        SqlSession sqlSession3 = SqlSessionFactoryUtil.openSqlSession();

        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        UserDao userDao3 = sqlSession3.getMapper(UserDao.class);

        System.out.println(userDao1.findAll());
        //sqlSession使用完之后，要关闭
        sqlSession1.close();

        System.out.println("------------------------------------------------------------------------------");

        System.out.println(userDao2.findAll());
        sqlSession2.close();

        userDao3.deleteById(24);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(userDao3.findAll());
        sqlSession3.close();
    }
}
