package com.example.ShowResultsService.service;

import com.example.ShowResultsService.entity.Result;
import com.example.ShowResultsService.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsService {

    @Autowired
    private ResultsRepository resultsRepository;

    public List<Result> getAllData() {
        return resultsRepository.findAll();
    }
}