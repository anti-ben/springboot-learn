package com.anti.springbootbase.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ReturnException handler01(HttpServletRequest request, ServiceException e) {
        ReturnException returnException = new ReturnException();
        returnException.setCode(600);
        returnException.setMsg(e.getMessage());
        returnException.setUrl(String.valueOf(request.getRequestURL()));
        return returnException;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handler02(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ExeMsg", e.getMessage());
        modelAndView.addObject("ReqUrl", request.getRequestURL());
        modelAndView.setViewName("/exemsg");
        return modelAndView;
    }
}
