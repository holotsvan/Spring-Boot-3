package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

//    @Before("execution(* add*())")
//    @Before("execution(public void add*())")
//    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account))")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account,boolean))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* com.luv2code..add*(..))")
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Excecuting @Before advice");
    }


}
