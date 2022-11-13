package com.atguigu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    /**
     * 只要出现ArithmeticException异常就会通过handleException方法来处理
     * 并且异常信息会通过model共享到请求域,跳转到error逻辑视图
     * @param ex
     * @param model
     * @return
     */
    //设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model){
        //ex表示控制器方法所出现的异常
        model.addAttribute("ex",ex);
        return "error";
    }
}
