package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return teamName;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!!!";
    }

    @GetMapping("/goodby")
    public String goodby() {
        return "Goodby.";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day.";
    }
}
