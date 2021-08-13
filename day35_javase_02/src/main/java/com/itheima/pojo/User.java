package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 包名:com.itheima.pojo
 * @author Leevi
 * 日期2020-10-28  14:36
 * 1. 麻烦
 * 2. 不便于修改
 *
 * 解决麻烦: 编码阶段不写get、set方法、toString()方法、构造函数，让其在编译阶段自动生成在class文件中
 * 我可使用lombok工具来实现
 *
 * 使用lombok的步骤:
 * 1. 下载插件
 * 2. 在需要使用lombok的项目中引入依赖
 * 3. 给要使用lombok的类加上注解
 * @Data注解，可以生成get、set、toString()、equals()、hashCode()方法等等
 * @AllArgsConstructor注解可以生成全参构造函数
 * @NoArgsConstructor注解可以生成无参构造
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String birthday;
    private String address;
}
