package com.miguelo.io.consumoGasolinaServer.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguelo.io.consumoGasolinaServer.entity.Car;
import com.miguelo.io.consumoGasolinaServer.repository.CarRepository;

@RestController
public class CoolCarController {

	private CarRepository repository;

    public CoolCarController(CarRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/cool-cars")
    public Collection<Car> coolCars() {
        return repository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }
    
    private boolean isCool(Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }

}
