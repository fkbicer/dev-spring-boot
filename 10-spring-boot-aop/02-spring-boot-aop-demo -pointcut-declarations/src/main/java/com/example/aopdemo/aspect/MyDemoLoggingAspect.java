package com.example.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
        pointcut="execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning="result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call.
        System.out.println("\n=====>>> result is: " + result);

        // lets post-process the data... lets modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> modified result is: " + result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }
    }

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
