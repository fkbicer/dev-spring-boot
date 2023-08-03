package com.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
    
    

    }

}
