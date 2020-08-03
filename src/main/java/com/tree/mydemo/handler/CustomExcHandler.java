package com.tree.mydemo.handler;


import com.tree.mydemo.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExcHandler {

//    @ExceptionHandler(value = Exception.class)
//    JsonData HandlerException(Exception e, HttpServletRequest r){
//
//        return JsonData.buildError("error");
//
//    }

    @ExceptionHandler(value = Exception.class)
    Object handlerExc(Exception e, HttpServletRequest r){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }


}
