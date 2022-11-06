package com.atguigu.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id);
        // 如果return "success"则响应了一个页面
        // 对于ajax请求,服务器是不能以转发或者重定向响应到浏览器的
        //return "success";
        response.getWriter().write("hello, axios");
    }
}
