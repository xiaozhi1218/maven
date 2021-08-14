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
     * 根据uid查询用户信息
     * @param uid
     * @return
     */
    User findUserByUid(int uid);
}
