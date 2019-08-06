package com.oksana.carsproduction.services;

import com.oksana.carsproduction.entity.Car;
import com.oksana.carsproduction.entity.Transaction;
import com.oksana.carsproduction.entity.User;
import com.oksana.carsproduction.repositories.AccountRepository;
import com.oksana.carsproduction.repositories.CarRepository;
import com.oksana.carsproduction.repositories.TransactionRepository;
import com.oksana.carsproduction.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    public Transaction buyCar(Long userId, Car car){
        Car foundCar = this.carRepository.findById(car.getId()).orElseThrow(() -> new RuntimeException("Car was not found"));
        User foundUser = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User was not found"));
        Transaction transaction = new Transaction();
        transaction.setUser(foundUser);
        transaction.setCar(foundCar);
        this.transactionRepository.save(transaction);
        BigDecimal demand = accountService.getBalance(foundUser, LocalDateTime.now()).subtract(foundCar.getPrice());

        this.accountRepository.findByUserId(foundUser.getId()).orElseThrow(()-> new RuntimeException("Account was not found"))
                .setAmount(demand);
        return transaction;
    }
    public Transaction purchaseReturn(Long userId, Car car){
        User foundUser = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User was not found"));
        Car foundCar = this.carRepository.findById(car.getId()).orElseThrow(() -> new RuntimeException("Car was not found"));
        Transaction transaction = new Transaction();
        transaction.setUser(foundUser);
        transaction.setCar(foundCar);
        this.transactionRepository.save(transaction);
        BigDecimal refund = foundCar.getPrice();
        this.accountRepository.findByUserId(foundUser.getId()).orElseThrow(()-> new RuntimeException("Account was not found"))
                .setAmount(this.accountService.getBalance(foundUser, LocalDateTime.now()).add(refund));
        return transaction;
    }
}
