package com.itheima.dao;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-10-30  10:23
 */
public interface AccountDao {
    /**
     * 根据uid查询账号的集合
     * @param uid
     * @return
     */
    List<Account> findAccountListByUid(int uid);
}
