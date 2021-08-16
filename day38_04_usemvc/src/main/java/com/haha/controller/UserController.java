package com.haha.controller;

import com.itheima.framework.Controller;
import com.itheima.framework.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 包名:com.haha.controller
 * @author Leevi
 * 日期2020-11-01  15:19
 * 1. 引入黑马_mvc的依赖
 * 2. 在我项目的web.xml配置文件中配置DispatcherServlet
 *    2.1 配置映射路径为"*.do"
 *    2.2 配置初始化参数scanPackage的值
 *    2.3 配置启动服务器时创建DispatcherServlet
 * 3. 给要处理请求的UserController类添加Controller注解
 * 4. 给要处理请求的方法添加RequestMapping注解
 */
@Controller
public class UserController {

    @RequestMapping("/user/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("add.......");
    }

    @RequestMapping("/user/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("delete.......");
    }

    @RequestMapping("/user/update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("update.......");
    }

    @RequestMapping("/user/query")
    public void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("query.......");
    }
}
