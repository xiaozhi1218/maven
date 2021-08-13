package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
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
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = mapper.findByUsernameAndAddress("jax", "深圳");

        System.out.println(user);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        Map map = new HashMap<>();
        map.put("username","奥巴马");
        map.put("sex","女");
        map.put("uid",24);
        mapper.updateUser(map);

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }

    @Test
    public void test03(){
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setSex("男");
        user.setAddress("北京");

        QueryVo queryVo = new QueryVo(1l,5,user);
        List<User> userList = mapper.searchByCondition(queryVo);

        for (User user1 : userList) {
            System.out.println(user1);
        }

        SqlSessionFactoryUtil.commitAndClose(sqlSession);
    }
}
