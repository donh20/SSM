package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 1. @ReuqestBody:将请求体中的内容和控制器方法的形参进行绑定,现在只需要在形参上加@RequestBody
 * 2. 使用@RequestBody注解将json格式的请求参数转换为java对象
 * a>导入jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-driven />
 * c>在处理请求的控制器方法的形参位置,直接设置json格式的请求参数要转换的java类型的形参,使用@RequestBody注解标识即可
 */
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response, @RequestBody String requestBody) throws IOException {
        System.out.println("id:" + id);
        System.out.println(requestBody);
        // 如果return "success"则响应了一个页面
        // 对于ajax请求,服务器是不能以转发或者重定向响应到浏览器的
        //return "success";
        response.getWriter().write("hello, axios");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello, ResponseBody.");
    }

    //有实体类能接收参数就用实体类,否则就用map
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello, ResponseBody.");
    }
}
