package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    
    //this is where we add all of our related adcivces for logging

    // let's start with an @Before

    @Before("execution(* add*(com.example.aopdemo.Account))")
    public void beforeAddAccountAdvice(){
     
        System.out.println("\n========> Executing @Before advice on addAccount()");

    }
}
