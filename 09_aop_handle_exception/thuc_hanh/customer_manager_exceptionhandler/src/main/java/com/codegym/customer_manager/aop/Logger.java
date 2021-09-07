package com.codegym.customer_manager.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {

    @Pointcut("execution(* com.codegym.customer_manager.model.service.CustomerService.findAll(..))")
    public void findAllPointCut(){
    }

    @After( "findAllPointCut()" )
    public void log(){
        System.err.println("Ban da nhap dung");
    }

}
