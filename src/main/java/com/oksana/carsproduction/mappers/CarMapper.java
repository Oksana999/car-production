package com.oksana.carsproduction.mappers;

import com.oksana.carsproduction.dtos.CarDto;
import com.oksana.carsproduction.entity.Car;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CarMapper {

    private final ModelMapper modelMapper;

    public Car mapToEntity(CarDto carDto){
       return this.modelMapper.map(carDto, Car.class);
    }

    public CarDto mapToDto(Car car){
       return this.modelMapper.map(car, CarDto.class);
    }
}
