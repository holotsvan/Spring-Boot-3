package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }

    @PostConstruct
    public void doMyStuff(){
        System.out.println("I'm in doMyStuff()");
    }

    @PreDestroy
    public void doMyCleanStuff(){
        System.out.println("I'm in doMyCleanStuff()");
    }
}
