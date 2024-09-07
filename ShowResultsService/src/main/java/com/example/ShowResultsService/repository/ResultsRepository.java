package com.example.ShowResultsService.repository;

import com.example.ShowResultsService.entity.Result;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultsRepository extends MongoRepository<Result, String> {

}