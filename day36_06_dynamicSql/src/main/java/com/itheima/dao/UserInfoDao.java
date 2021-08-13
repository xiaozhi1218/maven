package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-10-29  16:41
 */
public interface UserInfoDao {
    List<User> findAll();
}
