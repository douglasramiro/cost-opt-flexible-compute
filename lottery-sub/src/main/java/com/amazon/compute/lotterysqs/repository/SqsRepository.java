package com.amazon.compute.lotterysqs.repository;

import com.amazon.compute.lotterysqs.to.Lottery;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Repository
@RequiredArgsConstructor
public class SqsRepository {

    private final SqsClient client;
    private final Gson gson;

    @Value("${queue_name}")
    private String queueName;

    public void publishToSqS(Lottery lottery) {
        client.sendMessage(SendMessageRequest.builder()
                .queueUrl(getUrl(queueName))
                .messageBody(gson.toJson(lottery))
                .delaySeconds(10)
                .build());
    }

    private String getUrl(String queueName){
        GetQueueUrlResponse response = client.getQueueUrl(GetQueueUrlRequest.builder().queueName(queueName).build());
        return response.queueUrl();
    }
}
