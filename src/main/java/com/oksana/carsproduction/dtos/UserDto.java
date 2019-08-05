package com.oksana.carsproduction.dtos;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDto {

    private String userName;

    private String password;
}
