package com.oksana.carsproduction.repositories;


import com.oksana.carsproduction.entity.User;

import java.util.Optional;

public interface UserRepository extends Repository<User> {

    Optional<User> findByUsername(String userName);
}
