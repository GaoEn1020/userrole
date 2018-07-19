package com.piesat.user.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * 1、在class上添加注解@ControllerAdvice;
 * 2、在class中添加一个方法
 * 3、在方法上添加@ExceptionHandler拦截相应的异常信息
 * 4、如果返回的是View --方法的返回值是ModelAndView
 * 6、如果返回的是String或是Json,那么需要在方法上添加@ResponseBody注解
 */
@ControllerAdvice
public class GlobalDefaultDexceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExcetptionHandler(HttpServletRequest req,Exception e){

        return "no!!!对不起，服务器繁忙，稍后再试！";
    }
}
