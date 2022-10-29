package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String portal(){
        //逻辑视图
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        //逻辑视图
        return "hello";
    }
}
