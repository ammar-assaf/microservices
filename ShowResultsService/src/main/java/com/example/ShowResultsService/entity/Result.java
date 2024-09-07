package com.example.ShowResultsService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "Results")
public class Result {
    @Id
    private String id;
    private String max;
    private String min;
    private String avg;
    private String sum;
    private String count;
    private String std;
}
