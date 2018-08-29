package com.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engine {
    private Integer capacity;
    private Integer numCylinders;
    private Integer maxRpm;
    private Character manufacturerCode;
}
