package com.app.controller;

import com.app.entity.Car;
import com.app.entity.Engine;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class CarControllerTest {
    private static final String URL = "http://localhost:8080/car";

    @Autowired
    private WebTestClient testClient;

    @Test
    public void test() {
        Car car = testCar();

        testClient.post()
                .uri(URL + "/save")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(car), Car.class)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        String jsonValue = new Gson().toJson(car);
        testClient.get()
                .uri(URL + "/" + car.getSerialNumber())
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .json(jsonValue);
    }

    private static Car testCar() {
        Car car = new Car();
        car.setSerialNumber(1D);
        car.setOwnerName("Maseratti");
        car.setModelYear(2008d);
        car.setCode("ASWDF31223423");
        car.setVehicleCode("423324235");
        Engine engine = new Engine();
        engine.setCapacity(33);
        engine.setNumCylinders(8);
        engine.setMaxRpm(9000);
        engine.setManufacturerCode('M');
        car.setEngine(engine);
        car.setManufacturer("Maseratti Co.");
        car.setModel("Quattroporte");
        car.setActivationCode("HZ");
        return car;
    }
}
