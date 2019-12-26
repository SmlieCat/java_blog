package com.example.demo1.handler;

//异常拦截处理

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice  //异常拦截注解，可拦截@Controller
public class ControllerExceptionHandler {

//    记录异常
    private final Logger logger = LoggerFactory.getLogger(this.getClass());



    @ExceptionHandler(Exception.class)//    用来标识方法可做异常处理，内部是异常处理级别
//    处理异常信息，把异常传递给logger
    public ModelAndView execptionHander(HttpServletRequest request, Exception e){
        logger.error("Request URL: {}， Exception: {}", request.getRequestURI(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
