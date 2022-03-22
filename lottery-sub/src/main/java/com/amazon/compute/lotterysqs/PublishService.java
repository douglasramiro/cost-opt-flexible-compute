package com.amazon.compute.lotterysqs;

import com.amazon.compute.lotterysqs.repository.SqsRepository;
import com.amazon.compute.lotterysqs.to.Lottery;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PublishService {

    private final SqsRepository sqsRepository;

    @Scheduled(cron = "*/1 * * * * *")
    public void publishNewJoke(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 6){
            randomNumbers.add(generateRandonNumber());
        }
        Lottery lottery = new Lottery(LocalDateTime.now(),randomNumbers);
        sqsRepository.publishToSqS(lottery);
        System.out.println("Published a new message at : "+LocalDateTime.now());

    }

    private Integer generateRandonNumber(){
        return new Random().nextInt(69) + 1;
    }
}
