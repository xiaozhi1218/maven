package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-10-30  11:31
 */
public interface UserDao {
    User findUserRoleListByUid(int uid);
}
