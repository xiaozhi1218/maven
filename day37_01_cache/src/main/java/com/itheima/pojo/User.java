package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 包名:com.itheima.pojo
 *
 * @author Leevi
 * 日期2020-10-29  09:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private Integer uid;
    private String username;
    private String address;
    private String sex;
    private Date birthday;
}
