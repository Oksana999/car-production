package com.oksana.carsproduction.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

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
    private BigDecimal price;

    @Column
    private String imageName;
}
