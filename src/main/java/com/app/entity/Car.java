package com.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Car implements Serializable {
    @Id
    private Double serialNumber;
    private String ownerName;
    private Double modelYear;
    private String code;
    private String vehicleCode;
    private FuelFigures fuelFigures;
    private Engine engine;
    private PerformanceFigures performanceFigures;
    private String manufacturer;
    private String model;
    private String activationCode;

}
