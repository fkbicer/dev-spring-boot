package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Tennis- Practice fast bowling for 45 minutes :))";
    }
    
}
