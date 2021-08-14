package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from t_user where uid=#{uid}")
    @Results({
            @Result(id = true,column = "uid",property = "uid"),
            @Result(property = "accountList",column = "uid",many = @Many(select = "com.itheima.dao.AccountDao.findAccountListByUid"))
    })
    User findUserByUid(int uid);
}
