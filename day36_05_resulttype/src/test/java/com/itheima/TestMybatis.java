package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.pojo.UserInfo;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 包名:com.itheima
 *
 * @author Leevi
 * 日期2020-10-29  12:30
 */
public class TestMybatis {
    @Test
    public void test01(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        Long total = userDao.findTotal();
        System.out.println(total);

        User user = userDao.findById(9);
        System.out.println(user);

        Map userMap = userDao.findByUsername("jax");
        System.out.println(userMap);

        List<UserInfo> userInfoList = userDao.findAllUserInfo();

        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
