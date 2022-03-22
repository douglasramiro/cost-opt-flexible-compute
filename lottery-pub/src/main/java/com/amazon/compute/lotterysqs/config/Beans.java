package com.amazon.compute.lotterysqs.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Component
public class Beans {

    @Bean
    public SqsClient newSqsClient(){
        return SqsClient.builder().region(Region.US_EAST_1).build();
    }

    @Bean
    public Gson newGson(){
        return new Gson();
    }
}
