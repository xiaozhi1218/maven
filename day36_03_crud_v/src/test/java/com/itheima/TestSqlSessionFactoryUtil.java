package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-10-29  12:13
 */
public class TestSqlSessionFactoryUtil {
    @Test
    public void testFindById(){
        //1. 创建SqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        //2. 创建UserDao的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //3. 调用userDao对象的findById()方法
        System.out.println(userDao.findById(24));
        //4. 关闭资源，提交事务
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
