package com.example.AnalyticsService.service;

import com.example.AnalyticsService.entity.Data;
import com.example.AnalyticsService.entity.Result;
import com.example.AnalyticsService.repository.DataRepository;
import com.example.AnalyticsService.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {
    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private ResultRepository resultRepository;

    @Scheduled(fixedRate = 600000) // 10 Minute
    public void performAnalytics() {

        Result result;
        List<Data> dataEntries = dataRepository.findAll();

        if (dataEntries.isEmpty()) {
            return;
        }


        List<Double> values = dataEntries.stream()
                .map(Data::getTemperature)
                .toList();


        double avg = dataRepository.findAverageTemperature();
        double min = dataRepository.findMinTemperature();
        double max = dataRepository.findMaxTemperature();
        double sum = dataRepository.findSumTemperature();
        long count = dataRepository.count();
        double std = calculateStandardDeviation(values, avg);

        List<Result> results = resultRepository.findAll();

        if(!results.isEmpty()) {
            result = results.get(0);
        }else{
            result = new Result();
        }

        result.setAvg(String.valueOf(avg));
        result.setMin(String.valueOf(min));
        result.setMax(String.valueOf(max));
        result.setSum(String.valueOf(sum));
        result.setStd(String.valueOf(std));
        result.setCount(String.valueOf(count));


        resultRepository.save(result);
    }

    private double calculateStandardDeviation(List<Double> values, double mean) {
        double variance = values.stream()
                .mapToDouble(v -> Math.pow(v - mean, 2))
                .average()
                .orElse(0.0);
        return Math.sqrt(variance);
    }
}
