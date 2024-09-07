package com.example.AnalyticsService.repository;

import com.example.AnalyticsService.entity.Result;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository extends MongoRepository<Result, String> {
}
