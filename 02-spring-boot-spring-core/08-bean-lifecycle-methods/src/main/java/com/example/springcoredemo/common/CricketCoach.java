package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define init method
    @PostConstruct
    public void doMyStartupStaff(){
        System.out.println("In doMyStartupStaff():" + getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void doMyCleanupStaff(){
        System.out.println("In doMyCleanupStaff():" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
       return "Cricket - Practice fast bowling for 15 minutes :))";
    }


    
}
