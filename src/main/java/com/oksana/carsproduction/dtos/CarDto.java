package com.oksana.carsproduction.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CarDto {
    private Long id;

    private String model;

    private String brand;

    private String yearBuild;

    private Double price;

    private String imageName;
}
