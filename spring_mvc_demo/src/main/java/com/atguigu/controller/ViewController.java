package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMVC中的视图是View接口，视图的作用是渲染数据，把模型Model中的数据展示给用户
 * SpringMVC视图的种类有很多，默认有转发视图和重定向视图，当工程引入jstl的依赖，转发视图会自动转换为jstlview(jstlview已经很少用了)
 * 若使用的视图技术为Thymeleaf在SpringMVC的配置文件中配置了Thymeleaf的视图解析器，有此视图解析之后得到的是ThymeleafView
 *
 */
@Controller
public class ViewController {

    /**
     * 当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析，
     * 视图名称拼接视图前缀和后缀得到最终路径，通过转发的方式实现跳转
     * @return
     */

    @RequestMapping("/test/view/thymeleaf")
    public String testThymleafView(){
        return "success";
    }

    /**
     * SpringMVC中默认的转发视图是InternalResourceView
     * 当控制器方法中所设置的视图名称以forward:为前缀时,创建InternalResourceView视图，此时的视图名称不会被SpringMVC配置文件中所配置的
     * 视图解析器解析，而是会将前缀"forward:"去掉,剩余部分作为最终路径通过转发的方式实现跳转
     * 例如"forward:/","forward:/employee","forward:/test/model"
     *
     * @return
     */

    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        return "forward:/test/model";
    }

    /**
     * 重定向视图：
     * SpringMVC默认的视图就是重定向视图RedirectView
     * @return
     */
    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        return "redirect:/test/model";
    }
}
