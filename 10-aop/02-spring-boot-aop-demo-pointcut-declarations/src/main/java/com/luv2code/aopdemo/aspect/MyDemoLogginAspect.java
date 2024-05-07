package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLogginAspect {


    //    @Before("forDAOPackage()")
    @Before("com.luv2code.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\n=====>>> Excecuting @Before advice");
        // display method signature
        System.out.println("Method:" + methodSignature);

        // get args
        Object[] args = joinPoint.getArgs();
        // loop args
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account theAccount = (Account) arg;
                System.out.println("Account name:" + theAccount.getName());
                System.out.println("Account level:" + theAccount.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))"
            , returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("\n==========> Excecuting @AfterReturning advice");
        System.out.println("Method:" + joinPoint.getSignature().toShortString());
        System.out.println("Result is : " + result);
        // Update names
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("\n==========> Excecuting @AfterThrowing advice");
        System.out.println("Method:" + joinPoint.getSignature().toShortString());
        System.out.println("Exception is : " + exception.getMessage());
    }

    @After(
            "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("\n==========> Excecuting @After advice");
        System.out.println("Method:" + joinPoint.getSignature().toShortString());
    }

    @Around(
            "execution(* com.luv2code.aopdemo.service.*.getFortune(..))"
    )
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("\n==========> Excecuting @Around advice");
        System.out.println("Method:" + proceedingJoinPoint.getSignature().toShortString());

        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Duration:" + duration + "ms");
        return result;
    }

}
