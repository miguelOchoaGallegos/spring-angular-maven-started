package com.miguelo.io.consumoGasolinaServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.miguelo.io.consumoGasolinaServer.entity.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

}
