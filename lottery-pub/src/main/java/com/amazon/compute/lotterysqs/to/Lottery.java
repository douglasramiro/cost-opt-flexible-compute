package com.amazon.compute.lotterysqs.to;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@AllArgsConstructor
public class Lottery {
    private LocalDateTime generatedAt;
    private List<Integer> generatedNumbers;
}
