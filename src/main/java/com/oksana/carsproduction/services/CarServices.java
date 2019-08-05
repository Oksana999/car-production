package com.oksana.carsproduction.services;

import com.oksana.carsproduction.entity.Car;
import com.oksana.carsproduction.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServices {

    private final CarRepository carRepository;

    public Car create(Car car) {
        return this.carRepository.save(car);
    }
    public Optional<Car> get(Long id){
        Optional<Car> byId = this.carRepository.findById(id);
//                .filter(x -> x.getPrice() > 100000.0)
//                .orElse(Optional.of(new Car()));
        return byId;
    }

    public Car update(Car car){
        return this.carRepository.save(car);
    }

    public void delete(Car car){
        this.carRepository.delete(car);
    }
    public void delete1(Long id){
        Car car = this.carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        this.carRepository.delete(car);
    }

    public Page<Car> getAll(Pageable pageable){
       return this.carRepository.findAll(pageable);
    }


}
