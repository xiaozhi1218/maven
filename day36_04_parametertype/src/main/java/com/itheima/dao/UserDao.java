package com.itheima.dao;

import com.itheima.pojo.QueryVo;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 包名:com.itheima.dao
 * @author Leevi
 * 日期2020-10-29  12:22
 * mybatis的映射配置文件的parameterType参数类型:
 * 1. 单个参数，方法就以简单类型传入即可，那么在映射配置文件中的parameterType的值就是这个简单类型的别名
 *    在SQL语句中引入简单类型的参数#{任意字符串}
 *
 * 2. 多个参数:
 *    1. 传入多个简单类型的参数(不太提倡)我们需要通过Param注解给每个参数取名,那么在映射配置文件中就不写parameterType
 *    在SQL语句中引入参数#{Param注解的值}
 *
 *    2. 将多个参数封装到一个POJO中,那么在映射配置文件中parameterType的值就是这个POJO的全限定名或者别名
 *    在SQL语句中引入参数#{POJO的属性名}或者'${POJO的属性名}'
 *
 *    3. 将多个参数封装到一个Map中(要封装的参数没有对应的POJO),那么在映射配置文件中parameterType的值是map,
 *    在SQL语句中引入参数#{map的key}或者'${map的key}'
 *
 *    4. 将多个参数封装到一个POJO的包装对象中
 *       什么是POJO的包装对象，也就是说POJO中的属性类型又是一个其他的POJO类型, 那么我们在映射配置文件中的parameterType的值就是包装类型的别名
 *    在SQL语句中引入参数#{属性名.属性名}
 *
 */
public interface UserDao {
    User findById(int id);

    User findByUsernameAndAddress(@Param("uname") String username, @Param("addr") String address);

    void addUser(User user);

    void updateUser(Map map);

    List<User> searchByCondition(QueryVo queryVo);
}
