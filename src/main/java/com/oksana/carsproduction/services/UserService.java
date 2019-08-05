package com.oksana.carsproduction.services;

import com.oksana.carsproduction.entity.User;
import com.oksana.carsproduction.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User user){
       return this.userRepository.save(user);
    }
    public Optional<User> findById(Long id){
        Optional<User> byId = this.userRepository.findById(id);
        return byId;
    }
    public User update(User user){

        return this.userRepository.save(user);
    }

    public Optional<User> findByName(String userName){
       return this.userRepository.findByUsername(userName);
    }
    public Page<User> findAll(Pageable pageable){
       return this.userRepository.findAll(pageable);
    }
}
