package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 包名:com.itheima
 * 目标: 使用者只调用第一次查询，由mybatis选择调用第二次查询
 *
 * 懒加载是需要配置的:
 *  1. 局部懒加载: 只在你配置了的地方才会进行懒加载
 *  2. 全局懒加载:
 */
public class TestMybatis {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findUserByUid(1);

        System.out.println(user);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
