package com.oksana.carsproduction.controllers;

import com.oksana.carsproduction.dtos.AccountDto;
import com.oksana.carsproduction.entity.AccountingEntry;
import com.oksana.carsproduction.entity.User;
import com.oksana.carsproduction.mappers.AccountMapper;
import com.oksana.carsproduction.services.AccountService;
import com.oksana.carsproduction.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountMapper accountMapper;
    private final AccountService accountService;
    private final UserService userService;

    @PostMapping
    public AccountDto create (AccountDto accountDto){
       return this.accountMapper.mapToDto(this.accountService.create(this.accountMapper.mapToEntity(accountDto)));
    }

    @GetMapping("/{userId}")
    public List<AccountDto> findByUserId(@PathVariable Long userId){
        User user = this.userService.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<AccountingEntry> accountingEntries = this.accountService.findByUser(user);
        return accountingEntries.parallelStream().map(accountMapper::mapToDto).collect(Collectors.toList());
    }

    @GetMapping("/{userId}/balance")
    public BigDecimal getBalance (@PathVariable Long userId, @RequestParam LocalDateTime localDateTime){
        User user = this.userService.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        return this.accountService.getBalance(user, localDateTime);
    }

    @PutMapping("/{accountId}")
    public AccountDto update(@PathVariable Long accountId, AccountDto accountDto){
        accountDto.setId(accountId);
        return this.accountMapper.mapToDto(this.accountService.update(this.accountMapper.mapToEntity(accountDto)));
    }

    @DeleteMapping("/{accountId}")
    public void delete (@PathVariable Long accountId){
        this.accountService.delete(this.accountService.findById(accountId));
    }
}
