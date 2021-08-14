package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 包名:com.itheima.pojo
 *
 * @author Leevi
 * 日期2020-10-30  11:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String sex;
    private String birthday;
    private String address;

    private List<Role> roleList; //这就表示user和role的一对多关系
}
