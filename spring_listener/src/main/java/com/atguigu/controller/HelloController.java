package com.atguigu.controller;

import com.atguigu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    /*Controller里自动装配Service*/
    @Autowired
    private HelloService helloService;
}
