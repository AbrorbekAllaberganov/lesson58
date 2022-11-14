package com.example.lesson58.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulingJob {

    //  00:00
//
//    @Scheduled(fixedDelay = 2000L)
//    void work(){
//        System.out.println(new Date());
//    }


//    @Scheduled(initialDelay = 3000L,fixedRate = 2000L)
//    void work(){
//        System.out.println(new Date());
//    }

//    20-may   iyul

    @Scheduled(cron = "* 18 13 * * ?")  // soniya minut soat kun oy
    void work(){
        System.out.println(new Date());
    }

}
