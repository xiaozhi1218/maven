package com.itheima.dao;

import com.itheima.pojo.User;

/**
 * 包名:com.itheima.dao
 * @author Leevi
 * 日期2020-10-29  12:22
 *
 */
public interface UserDao {
    /**
     * 根据用户的uid查询到一个用户信息，并且连接账号表查询该用户的所有账号
     * @param uid
     * @return
     */
    User findUserAccountListByUid(int uid);
}
