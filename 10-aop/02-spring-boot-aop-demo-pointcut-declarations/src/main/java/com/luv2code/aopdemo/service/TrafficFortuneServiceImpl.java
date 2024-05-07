package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "Expect heavy traffic this morning";
    }
}
