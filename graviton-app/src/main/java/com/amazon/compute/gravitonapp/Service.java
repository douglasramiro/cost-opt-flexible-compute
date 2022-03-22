package com.amazon.compute.gravitonapp;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {



    @Scheduled(cron = "*/1 * * * * *")
    public void printNew(){
        System.out.println("Hello from a Graviton Application "+ LocalDateTime.now());

    }

}
