package com.app.repository;

import com.app.entity.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car, Double> {
}
