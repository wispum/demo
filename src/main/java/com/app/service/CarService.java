package com.app.service;

import com.app.entity.Car;
import reactor.core.publisher.Mono;


public interface CarService {

    Mono<Car> getCarByNum(Double num);

    Mono<Void> saveCar(Car car);
}
