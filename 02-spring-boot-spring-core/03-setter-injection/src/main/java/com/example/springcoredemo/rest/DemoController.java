package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.Coach;

@RestController
public class DemoController {

private Coach myCoach;

@Autowired
public void setCoach(Coach theCoach) {
    myCoach = theCoach;
}
    
@GetMapping("/dailyworkout")
public String getDailyWorkout() {
    return myCoach.getDailyWorkout();
}
}
