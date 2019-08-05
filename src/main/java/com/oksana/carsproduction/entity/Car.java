package com.oksana.carsproduction.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "cars")
@Entity
public class Car extends BaseEntity {

    @Column
    private String model;
    @Column
    private String brand;
    @Column
    private String yearBuild;
    @Column
    private double price;

    @Column
    private String imageName;
}
