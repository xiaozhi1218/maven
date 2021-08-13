package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.pojo.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 包名:com.itheima.dao
 * @author Leevi
 * 日期2020-10-29  12:22
 * mybatis的映射配置文件的resultType表示将查询到的结果封装到什么里面
 * 1. 查询的结果是单个数据, 映射配置文件中的resultType属性的值就是这个数据的类型
 *
 * 2. 查询的结果是一行数据:
 *    2.1 将这一行数据存储到POJO对象中, 映射配置文件的resultType的值就是POJO的全限定名或者别名,此时就要求查询结果的字段名和类型
 *        要和POJO的属性名和类型一致
 *
 *    2.2 将这一行数据存储到Map对象,映射配置文件的resultType的值就是map，那么此时查询结果中的字段名就是
 *        map的key，字段值就是map的value
 *
 * 3. 查询的结果是多行数据:
 *   2.1 将多条数据存储到List<POJO>中，映射配置文件的resultType的值就是POJO的别名
 *   2.2 将多条数据存储到List<Map>中，映射配置文件的resultType的值就是map
 *
 * 4. 查询一行或者多行数据，将查询结果封装到POJO对象中，并且POJO的属性名和表的字段名不一致
 *    使用resultMap进行手动映射
 *
 */
public interface UserDao {
    /**
     * 查询用户的总个数
     * @return
     */
    Long findTotal();

    /**
     * 根据id查询一条数据
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    Map findByUsername(String username);

    /**
     * 查询所有用户信息，封装到UserInfo对象
     * @return
     */
    List<UserInfo> findAllUserInfo();
}
