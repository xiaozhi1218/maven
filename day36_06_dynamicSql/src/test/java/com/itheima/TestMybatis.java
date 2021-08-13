package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.dao.UserInfoDao;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> userList = mapper.findUserListByAddress(null);

        for (User user : userList) {
            System.out.println(user);
        }

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setAddress("北京");
        user.setSex("男");
        mapper.findUserListByAddressAndSex(user);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<Integer> ids = new ArrayList<>();

        //ids.add(1);
        //ids.add(2);
        //ids.add(3);
        //ids.add(4);

        mapper.deleteByIds(ids);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }


    @Test
    public void test04(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserInfoDao mapper = sqlSession.getMapper(UserInfoDao.class);

        System.out.println(mapper.findAll());
        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
