package com.itheima.dao;

import com.itheima.pojo.Account;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-10-30  10:23
 */
public interface AccountDao {
    /**
     * 根据aid查询账户信息，并且连接t_user表查询该账户所属的用户信息
     * @param aid
     * @return
     */
    Account findAccountUserByAid(int aid);
}
