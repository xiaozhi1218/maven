package com.itheima.dao;

import com.itheima.pojo.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-10-30  10:23
 *
 * Results就是手动映射
 */
public interface AccountDao {
    /**
     * 根据aid查询账号信息
     * @param aid
     * @return
     */
    @Select("select * from t_account where aid=#{aid}")
    @Results(
            {
                    //映射主键
                    @Result(column = "uid",property = "uid",id = true),
                    //调用第二步查询进行一对一映射
                    @Result(property = "user",column = "uid",one = @One(select = "com.itheima.dao.UserDao.findUserByUid"))
            }
    )
    Account findAccountByAid(int aid);
}
