package com.atguigu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ResponseEntity:可以作为控制器方法的返回值，表示响应到浏览器的完整的响应报文
 * 文件上传的要求:
 * 1. form表单的请求方式必须为post
 * 2. form表单必须设置属性enctype="multipart/form-data"
 */

@Controller
public class FileUpAndDownController {
    /**
     * ResponseEntity用于控制器方法的返回类型,该控制器方法的返回值就是响应到浏览器的响应报文
     * 只要把文件设置到响应体就可以实现下载文件功能
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("img");
        System.out.println(realPath);
        realPath = realPath + File.separator + "1.jpg";
        //创建输入流
        FileInputStream is = new FileInputStream(realPath);
        //is.available()用来获取输入流所对应的文件字节数,根据长度创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象,设置响应头信息,MultiValueMap本质上就是个map集合,键值对
        MultiValueMap<String,String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=2.jpg");
        //设置响应状态码
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, status);
        is.close();
        return responseEntity;
    }

    /**
     * SpringMVC把浏览器上传的文件给封装成了一个MultipartFile对象
     * 用获取请求参数的方式获取即可(需要额外在springmvc.xml里配置一个文件上传解析器)
     * 1. 配置文件上传解析器
     * <bean class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
     * </bean>
     * 2. pom文件添加相关的jar包
     * 3. 配置文件解析器的bean id="multipartResolver"
     *
     * @param session
     * @return
     */
    @RequestMapping("/test/up")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String filename = photo.getOriginalFilename();
        System.out.println(filename);
        //没有专门的文件服务器,直接上传到tomcat服务器,也就是target下的war包下面(spring_mvc_ajax1.0-SNAPSHOT)
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取当前工程的真实路径
        String photopath = servletContext.getRealPath("photo");
        //创建photoPath所对应的file对象
        File file = new File(photopath);
        //判断file所对应的目录是否存在
        if(!file.exists()) {
            file.mkdir();
        }
        final String finalPath = photopath + File.separator + filename;
        //上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
