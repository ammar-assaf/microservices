package com.example.DataEntryService.repository;

import com.example.DataEntryService.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {

}

