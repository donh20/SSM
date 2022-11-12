package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. @ReuqestBody:将请求体中的内容和控制器方法的形参进行绑定,现在只需要在形参上加@RequestBody
 * 2. 使用@RequestBody注解将json格式的请求参数转换为java对象
 * a>导入jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-driven />
 * c>在处理请求的控制器方法的形参位置,直接设置json格式的请求参数要转换的java类型的形参,使用@RequestBody注解标识即可
 * 3、@ResponseBody：将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
 * 4、使用@ResponseBody注解响应浏览器json格式的数据
 * a>导入jackson的依赖
 * b>在SpringMVC的配置文件中设置<mvc:annotation-driven />
 * c>将需要转换为json字符串的java对象直接作为控制器方法的返回值，使用@ResponseBody注解标识控制器方法
 * 就可以将java对象直接转换为json字符串，并响应到浏览器
 *
 * 常用的Java对象转换为json的结果：
 * 实体类-->json对象
 * map-->json对象
 * list-->json数组
 */
@Controller
//@RestController 相当于@Controller注解+@ResponseBody注解
public class TestAjaxController {

    /**
     * axios.post(
     *     "/SpringMVC/test/ajax?id=1001",
     *     {username:"admin",password:"123456"}
     * )
     * @param id
     * @param response
     * @param requestBody
     * @throws IOException
     */
    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id);
        System.out.println(requestBody);
        // 如果return "success"则响应了一个页面
        // 对于ajax请求,服务器是不能以转发或者重定向响应到浏览器的
        //return "success";
        response.getWriter().write("hello, axios");
    }

    /**
     * axios.post(
     *     "/SpringMVC/test/RequestBody/json",
     *     {username:"admin",password:"123456",age:23,gender:"男"}
     * )
     * @param map
     * @param response
     * @throws IOException
     */
    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello, RequestBody.");
    }

    //有实体类能接收参数就用实体类,否则就用map
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello, ResponseBody.");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
/*    public List<User> testResponseBodyJson(){
        User user1 = new User(1001, "admin1", "123456", 20, "男");
        User user2 = new User(1002, "admin2", "123456", 20, "男");
        User user3 = new User(1003, "admin3", "123456", 20, "男");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }*/
/*    public User testResponseBodyJson(){
        User user = new User(1001, "admin", "123456", 20, "女");
        return user;
    }*/
    public Map<String, Object> testResponseBodyJson(){
        User user1 = new User(1001, "admin1", "123456", 20, "男");
        User user2 = new User(1002, "admin2", "123456", 20, "男");
        User user3 = new User(1003, "admin3", "123456", 20, "男");
        Map<String, Object> map = new HashMap<>();
        map.put("1001",user1);
        map.put("1002",user2);
        map.put("1003",user3);
        return map;
    }
}
