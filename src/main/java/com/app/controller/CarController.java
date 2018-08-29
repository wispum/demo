package com.app.controller;

import com.app.entity.Car;
import com.app.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping(value = "/{serialNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Car> getCarBySerialNum(@PathVariable(name = "serialNumber") Double num) {
        return service.getCarByNum(num);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> saveCar(@RequestBody Car car) {
        return service.saveCar(car).then();
    }

}
