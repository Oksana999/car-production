package com.oksana.carsproduction.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="account")
public class AccountingEntry extends BaseEntity{

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    User user;

    @Column(name = "amount")
    BigDecimal amount;

    @Column (name = "is_debit")
    Boolean isDebit;

    @Column
    LocalDateTime date;
}
