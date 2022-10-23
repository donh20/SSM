package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class UserController {


    //@Autowired(required = false)  /*默认值为true:要求必须完成自动装配 false:装配则装配，无法装配则使用属性的默认值*/
    @Qualifier("userServiceImpl")   /*通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值*/
    @Autowired/*1. 标志在成员变量上,此时不需要设置成员变量的set方法*/
    private UserService userService;

/*    @Autowired*//*3. 标志在当前成员变量赋值的有参构造上*//*
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired*//*2. 标志在set方法上*//*
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/
    public void saveUser(){
        userService.saveUser();
    }
}
