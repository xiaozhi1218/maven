package com.itheima.framework;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leevi
 * 日期2020-11-01  12:00
 * object对象(Controller类的对象)和method和requestMappingValue是一一对应关系，所以将他们仨属性封装到一个对象中
 * 一个注解值对应一个MvcMethod, 不同的注解值对应不同的mvcMethod对象，所以可以用Map，注解值作为key，MvcMethod作为value
 */
public class DispatcherServlet extends HttpServlet {
    private Map<String,MvcMethod> map = new HashMap<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //config对象读取web.xml中servlet的初始化参数scanPackage
        String scanPackage = config.getInitParameter("scanPackage");
        //3.扫描Controller所在的整个包中的所有类: 指定包下的所有类的字节码对象
        List<Class<?>> classList = ClassScannerUtils.getClasssFromPackage(scanPackage);
        //4. 遍历出每一个字节码对象
        try {
            if (classList != null) {
                for (Class<?> clazz : classList) {
                    //判断类上是否有Controller注解
                    if (clazz.isAnnotationPresent(Controller.class)) {
                        //创建类的对象
                        Object object = clazz.newInstance();
                        //类上有Controller注解
                        //获取该字节码对象对应的类中的所有public方法
                        Method[] methods = clazz.getMethods();
                        //遍历出每一个公有方法
                        for (Method method : methods) {
                            //判断该方法上是否有RequestMapping注解
                            if (method.isAnnotationPresent(RequestMapping.class)) {
                                //方法上有RequestMapping注解，则获取该注解的值
                                String requestMappingValue = method.getAnnotation(RequestMapping.class).value();
                                map.put(requestMappingValue,new MvcMethod(object,method));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1. 获取请求的uri: /项目名/user/xxx.do
            String uri = request.getRequestURI();
            //2. 去掉"/项目名"和".do"
            //2.1 获取"/项目名"
            String contextPath = request.getContextPath();
            //2.2 获取到用于匹配的路径
            String mappingPath = uri.substring(contextPath.length(), uri.lastIndexOf("."));

            //遍历出mvcMethodList中的每一个对象
            MvcMethod mvcMethod = map.get(mappingPath);
            if (mvcMethod != null) {
                mvcMethod.getMethod().invoke(mvcMethod.getObject(),request,response);
                return;
            }

            //说明请求，没有对应的方法去处理
            throw new RuntimeException("No Method To Be Invoked.....");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
