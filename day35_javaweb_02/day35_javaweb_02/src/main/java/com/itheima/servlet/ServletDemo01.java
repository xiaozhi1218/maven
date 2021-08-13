package com.itheima.servlet;

import java.io.IOException;

/**
 * @author Leevi
 * 日期2020-10-28  10:50
 */
@javax.servlet.annotation.WebServlet("/demo01")
public class ServletDemo01 extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().write("hahahhahahaha");
    }
}
