package com.itheima.framework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Leevi
 * 日期2020-11-01  12:00
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求的uri: /项目名/user/xxx.do
        String uri = request.getRequestURI();
        //2. 去掉"/项目名"和".do"
        //2.1 获取"/项目名"
        String contextPath = request.getContextPath();
        //2.2 获取到用于匹配的路径
        String mappingPath = uri.substring(contextPath.length(), uri.lastIndexOf("."));

        //3.扫描Controller所在的整个包中的所有类: 指定包下的所有类的字节码对象
        List<Class<?>> classList = ClassScannerUtils.getClasssFromPackage("com.itheima.controller");
        //4. 遍历出每一个字节码对象
        try {
            if (classList != null) {
                for (Class<?> clazz : classList) {
                    //获取该字节码对象对应的类中的所有public方法
                    Method[] methods = clazz.getMethods();
                    //遍历出每一个公有方法
                    for (Method method : methods) {
                        //判断该方法上是否有RequestMapping注解
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            //方法上有RequestMapping注解，则获取该注解的值
                            String requestMappingValue = method.getAnnotation(RequestMapping.class).value();

                            //用mappingPath匹配RequestMappingValue
                            if (mappingPath.equals(requestMappingValue)) {
                                //匹配上了，则调用该方法
                                method.invoke(clazz.newInstance(),request,response);
                                return;
                            }
                        }
                    }
                }
            }

            //说明请求，没有对应的方法去处理
            throw new RuntimeException("No Method To Invoke.....");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
