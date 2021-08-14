package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * 包名:com.itheima.dao
 *
 * @author Leevi
 * 日期2020-10-29  11:02
 * mybatis的注解开发，就是在对应的Dao接口的方法上添加注解
 * 查询方法就对应Select注解
 * 添加方法就对应Insert注解
 * 删除方法就对应Delete注解
 * 修改方法就对应Update注解
 * 查询自增长的主键
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user 要添加进数据库的数据
     * @return 受到影响的行数
     */
    @Insert("insert into t_user (username,address,sex,birthday) values (#{username},#{address},#{sex},#{birthday})")
    @SelectKey(keyProperty = "uid",keyColumn = "uid",resultType = int.class,before = false,statement = "select last_insert_id()")
    int addUser(User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Delete("delete from t_user where uid=#{id}")
    int deleteById(int id);

    /**
     * 修改用户
     * @param user
     */
    @Update("update t_user set username=#{username},sex=#{sex},address=#{address} where uid=#{uid}")
    void updateUser(User user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from t_user where uid=#{id}")
    User findById(int id);
}
