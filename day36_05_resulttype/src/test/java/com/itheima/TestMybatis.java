package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.UserInfo;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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

        List<UserInfo> userInfoList = userDao.findAllUserInfo();

        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
