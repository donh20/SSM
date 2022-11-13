package com.atguigu.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器的三个方法：
 * preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截(false)或放行(true)
 * postHandle()：在控制器方法执行之后执行
 * afterCompletion()：在控制器方法执行之后，且渲染视图完毕之后执行
 *
 * 多个拦截器的执行顺序和在SpringMVC的配置文件中配置的顺序有关
 * preHandle()按照配置的顺序执行，而postHandle()和afterCompletion()按照配置的反序执行
 *
 * 若拦截器中有某个拦截器的preHandle()返回了false
 * 拦截器的preHandle()返回false和它之前的拦截器的preHandle()会顺序执行
 * "所有"的拦截器的postHandle()都不执行
 * 拦截器的preHandle()返回false"之前"的拦截器的afterCompletion()会倒序执行
 *
 * 注意: HandlerExecutionChain的handler是ParameterizableViewController [view="index"]
 * 这是SpringMVC在解析视图控制器的时候自己创建的方法,我们添加两个拦截器后,一共有四个拦截器
 * 1. AbstractUrlHandlerMapping$Path$ExposingHandlerInterceptor
 *  专门处理视图控制器所对应的请求
 * 2. ConversionServiceExposingInterceptor
 *  springMVC自带的
 * 3. FirstInterceptor
 * 4. SecondInterceptor
 *
 * 加载首页完成后,点击"测试拦截器",这个时候再进行debug
 *
 * 条件:firstInterceptor返回true,secondInterceptor返回false
 * FirstInterceptor--->preHandle
 * SecondInterceptor--->preHandle
 * FirstInterceptor--->afterCompletion
 *
 * 条件:firstInterceptor返回true,secondInterceptor返回true,thirdInterceptor返回false
 * FirstInterceptor--->preHandle
 * SecondInterceptor--->preHandle
 * ThirdInterceptor--->preHandle
 * SecondInterceptor--->afterCompletion
 * FirstInterceptor--->afterCompletion
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor--->preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor--->postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor--->afterCompletion");
    }
}
