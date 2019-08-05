package com.oksana.carsproduction.controllers;


import com.oksana.carsproduction.dtos.CarDto;
import com.oksana.carsproduction.entity.Car;
import com.oksana.carsproduction.mappers.CarMapper;
import com.oksana.carsproduction.services.CarServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarMapper carMapper;
    private final CarServices carService;

    @PostMapping
    public CarDto createCar(@RequestBody CarDto carDto){
      return this.carMapper.mapToDto(this.carService.create(this.carMapper.mapToEntity(carDto)))  ;
    }

    @GetMapping("/{id}")
    public CarDto getById(@PathVariable Long id){
        Car car = this.carService.get(id).orElseThrow(() -> new RuntimeException("Car was not been found"));
        return this.carMapper.mapToDto(car);
    }
    @GetMapping
    public Page<CarDto> getAll(Pageable pageable){
       return this.carService.getAll(pageable).map(this.carMapper::mapToDto);

    }
}
