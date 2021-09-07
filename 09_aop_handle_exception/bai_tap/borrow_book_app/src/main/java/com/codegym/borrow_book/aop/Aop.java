package com.codegym.borrow_book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aop {

    int  count = 0;

    @Pointcut("execution(* com.codegym.borrow_book.controller.BorrowBookController.setCode(..))")
    public void allMethodPointCut(){
    }

    @Pointcut("execution(* com.codegym.borrow_book.controller.BorrowBookController.returnBook(..))")
    public void allPointCut(){
    }

    @Pointcut("within(com.codegym.borrow_book.controller.BorrowBookController*)")
    public void allThing(){
    }

    @After("allThing()")
    public void allSignal(JoinPoint joinPoint){
         count = count+1;
        System.err.println(count);
    }

    @After("allMethodPointCut()")
    public void signal(JoinPoint joinPoint){
        System.err.println(joinPoint.getSignature().getName());
    }

    @After("allPointCut()")
    public void signaled(JoinPoint joinPoint){
        System.err.println(joinPoint.getSignature().getName());
    }
}
