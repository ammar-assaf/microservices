package com.example.AnalyticsService.repository;

import com.example.AnalyticsService.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DataRepository extends JpaRepository<Data, Long> {

    long count();

    @Query("SELECT MAX(d.temperature) FROM Data d")
    double findMaxTemperature();

    @Query("SELECT MIN(d.temperature) FROM Data d")
    double findMinTemperature();

    @Query("SELECT AVG(d.temperature) FROM Data d")
    double findAverageTemperature();

    @Query("SELECT SUM(d.temperature) FROM Data d")
    double findSumTemperature();
}
