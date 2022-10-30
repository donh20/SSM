package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 向域对象共享数据：
 * 1、通过ModelAndView向请求域共享数据
 * 使用ModelAndView时，可以使用其Model功能向请求域共享数据
 * 使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 * 2、使用Model向请求域共享数据
 * 3、使用ModelMap向请求域共享数据
 * 4、使用map向请求域共享数据
 * 5、Model和ModelMap和map的关系
 * 其实在底层中，这些类型的形参最终都是通过BindingAwareModelMap创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 */
@Controller
public class ScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView:
         * Model: 向请求域中共享数据
         * View: 设置逻辑视图实现页面跳转
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testRequestScope","hello, ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        //org.springframework.validation.support.BindingAwareModelMap
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope","hello, model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        //org.springframework.validation.support.BindingAwareModelMap
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope","hello, ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testModelMap(Map<String,Object> map){
        //org.springframework.validation.support.BindingAwareModelMap
        System.out.println(map.getClass().getName());
        map.put("testRequestScope","hello, Map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession httpSession){
        httpSession.setAttribute("testSessionScope","hello, session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession httpSession){
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("testApplicationScope","hello, session");

        return "success";
    }
}
