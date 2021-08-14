package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 包名:com.itheima
 * @author Leevi
 * 日期2020-10-29  12:30
 */
public class TestMybatis {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findUserRoleListByUid(3);

        System.out.println(user);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
