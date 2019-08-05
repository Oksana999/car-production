package com.oksana.carsproduction.mappers;

import com.oksana.carsproduction.dtos.UserDto;
import com.oksana.carsproduction.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public User mapToEntity(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    public UserDto mapToDto(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }


}
