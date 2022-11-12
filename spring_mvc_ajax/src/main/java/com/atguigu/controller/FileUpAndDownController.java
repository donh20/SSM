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
import java.util.UUID;

@Controller
public class FileUpAndDownController {
    /**
     * ResponseEntity用于控制器方法的返回类型,该控制器方法的返回值就是响应到浏览器的响应报文
     * 只要把文件设置到响应体就可以实现下载文件功能
     * ResponseEntity:可以作为控制器方法的返回值，表示响应到浏览器的完整的响应报文
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

}
