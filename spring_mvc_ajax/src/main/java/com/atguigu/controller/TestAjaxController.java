package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public String testAjax(Integer id){
        System.out.println("id" + id);
        return "success";
    }
}
