package com.example.DataEntryService.service;

import com.example.DataEntryService.entity.Data;
import com.example.DataEntryService.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public void saveData(Data data) {
        dataRepository.save(data);
    }
}

