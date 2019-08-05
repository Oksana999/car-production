package com.oksana.carsproduction.dtos;

import com.oksana.carsproduction.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountDto {

    private Long id;

    private BigDecimal amount;

    private Long userId;

    private LocalDateTime date;
}
