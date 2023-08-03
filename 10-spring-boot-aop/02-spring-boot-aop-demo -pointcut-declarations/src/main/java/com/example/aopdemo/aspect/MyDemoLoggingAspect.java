package com.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.example.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterAndSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n========> Executing @Before advice on method.");

        
    // display the method signature
    MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
    System.out.println("Method : " + methodSignature);
    // display method arguments

    Object[] args = theJoinPoint.getArgs();

    for(Object tempArg : args) {
        System.out.println(tempArg);

        if (tempArg instanceof Account) {

            Account theAccount = (Account) tempArg;
            System.out.println("Account name : " + theAccount.getName());
            System.out.println("Account level : " + theAccount.getLevel());

        }
    }
    

    }

}
