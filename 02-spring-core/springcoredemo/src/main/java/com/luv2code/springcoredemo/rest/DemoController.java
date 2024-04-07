package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotehrCoach;

// Constructor Injection
//    @Autowired
//    DemoController(@Qualifier("trackCoach") Coach theCoach){
//        myCoach=theCoach;
//    }

    // With @Primary
//    @Autowired
//    DemoController(Coach theCoach){
//        myCoach=theCoach;
//    }

    //Setter Injection
//    @Autowired
//    public void setCoach(@Qualifier("baseballCoach") Coach theCoach) {
//        myCoach = theCoach;
//    }


//    @Autowired
//    public void setCoach(
//            @Qualifier("cricketCoach") Coach theCoach,
//            @Qualifier("cricketCoach") Coach theAnotherCoach
//    ) {
//        myCoach = theCoach;
//        anotehrCoach = theAnotherCoach;
//    }

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach){
        myCoach= theCoach;
    }

    @GetMapping("/")
    public String index() {
        return "<h1>Hello, World!</h1>";
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach, "+ (myCoach==anotehrCoach);
    }
}
