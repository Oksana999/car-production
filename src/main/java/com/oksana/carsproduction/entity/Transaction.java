package com.oksana.carsproduction.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "transactions")
public class Transaction extends BaseEntity{
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @JoinColumn(name = "car_id")
    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Car car;

    @Column
    private LocalDateTime date;

}
