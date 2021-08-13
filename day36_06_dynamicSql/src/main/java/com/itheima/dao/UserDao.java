package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 包名:com.itheima.dao
 * @author Leevi
 * 日期2020-10-29  12:22
 *
 */
public interface UserDao {
    /**
     * 根据address查询用户,如果没有传入地址则查询出所有用户
     * @param address
     * @return
     */
    List<User> findUserListByAddress(@Param("address") String address);

    /**
     * 根据用户的地址和性别查询用户, 如果有address才考虑address的条件，如果有sex才考虑sex的条件
     * @param user
     * @return
     */
    List<User> findUserListByAddressAndSex(User user);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(List<Integer> ids);
}
