package com.app.service;

import com.app.entity.Car;
import com.app.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
class CarServiceImpl implements CarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);
    private final CarRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Car> getCarByNum(Double num) {
        LOGGER.info("getRequest with param {} was processed", num);
        return repository.findById(num);
    }

    @Override
    public Mono<Void> saveCar(Car car) {
        LOGGER.info("POSTRequest from client with obj {}", car.toString());
        return repository.save(car).then();
    }
}
