package com.oksana.carsproduction.controllers;

import com.oksana.carsproduction.configuration.TokenHelper;
import com.oksana.carsproduction.dtos.UserDto;
import com.oksana.carsproduction.entity.User;
import com.oksana.carsproduction.mappers.UserMapper;
import com.oksana.carsproduction.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private  final TokenHelper tokenHelper;

    @PostMapping
    public UserDto create (@RequestBody UserDto userDto){
     return this.userMapper.mapToDto(this.userService.create(this.userMapper.mapToEntity(userDto)) );
    }

     @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id){
       return this.userMapper.mapToDto(this.userService.findById(id)
                .orElseThrow(()-> new RuntimeException("User was not found")));
    }
    @PutMapping
    public UserDto update (@RequestBody UserDto userDto){
        // 1. new dto -> new entity
        // 2. find exist entity
        // 3. update exist entity
        // 4. save exist entity
        // 5. map exist entity -> dto
        // 6. return dto

        User newEntity = this.userMapper.mapToEntity(userDto); // 1
        User existEntity = this.userService.findById(newEntity.getId())
                .orElseThrow(EntityNotFoundException::new); // 2
        existEntity.setUsername(newEntity.getUsername()); // 3
        User updated = this.userService.update(existEntity);// 4
        return userMapper.mapToDto(updated); // 5 - 6

    }
    @GetMapping
    public Page<UserDto> findAll(Pageable pageable){
        return this.userService.findAll(pageable).map(this.userMapper::mapToDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        User user = this.userService.findByName(userDto.getUserName())
                .orElseThrow(() -> new RuntimeException("User was not found"));
       if( !BCrypt.checkpw(userDto.getPassword(), user.getPassword())){
           throw new RuntimeException("Error of authorisation");

       }
        return this.tokenHelper.tokenFor(user);
    }
}
