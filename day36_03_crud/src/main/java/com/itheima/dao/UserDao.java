package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-10-29  11:02
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user 要添加进数据库的数据
     * @return 受到影响的行数
     */
    int addUser(User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据用户名进行模糊查询
     * @param username
     * @return
     */
    List<User> searchByUsername(String username);
}
