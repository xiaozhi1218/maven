package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * @author Leevi
 * 日期2020-10-29  12:22
 *
 */
public interface UserDao {
    List<User> findAll();

    void deleteById(int id);
}
