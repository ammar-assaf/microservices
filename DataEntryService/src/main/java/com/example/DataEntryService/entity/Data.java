package com.example.DataEntryService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double temperature;
}
