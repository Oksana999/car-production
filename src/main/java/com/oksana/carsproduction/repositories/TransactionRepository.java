package com.oksana.carsproduction.repositories;

import com.oksana.carsproduction.entity.Car;
import com.oksana.carsproduction.entity.Transaction;
import com.oksana.carsproduction.entity.User;

import java.util.List;

public interface TransactionRepository extends Repository<Transaction> {
    public List<Transaction> getTransactionsByUser(User user);

    public Transaction findByUserIdAndCar(Long userId, Car car);
}
