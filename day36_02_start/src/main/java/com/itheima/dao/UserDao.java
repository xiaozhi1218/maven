package com.itheima.dao;
import com.itheima.pojo.User;
import java.util.List;

/**
 * 包名:com.itheima.dao
 * @author Leevi
 * 日期2020-10-29  09:14
 * 执行findAll()方法的目的是: 执行一个查询所有用户的sql语句，并且将查询到的结果封装到List<User>
 */
public interface UserDao {
    List<User> findAll();
}
