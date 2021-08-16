package com.itheima.controller;

import com.itheima.framework.Controller;
import com.itheima.framework.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 包名:com.itheima.controller
 * @author Leevi
 * 日期2020-11-01  11:55
 * 什么情况能用单例:
 *  只有方法
 *
 * 什么情况不能用单例
 *  有可改变的成员变量的情况
 */
@Controller
public class UserController {
    @RequestMapping("/user/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("add.....");
    }

    @RequestMapping("/user/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("delete.....");
    }

    @RequestMapping("/user/update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("update.....");
    }

    @RequestMapping("/user/query")
    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("query.....");
    }
}
