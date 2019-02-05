package com.miguelo.io.consumoGasolinaServer;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.miguelo.io.consumoGasolinaServer.entity.Car;
import com.miguelo.io.consumoGasolinaServer.repository.CarRepository;

@SpringBootApplication
public class ConsumoGasolinaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoGasolinaServerApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(CarRepository repository) {
		return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                      "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
                Car car = new Car();                
                car.setName(name);                
                repository.save(car);
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}

