package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 包名:com.itheima.pojo
 *
 * @author Leevi
 * 日期2020-10-29  15:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private Integer userId;
    private String username;
    private String userSex;
    private String userBirthday;
    private String userAddress;
}
