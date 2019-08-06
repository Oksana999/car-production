package com.oksana.carsproduction.mappers;

import com.oksana.carsproduction.dtos.AccountDto;
import com.oksana.carsproduction.entity.AccountingEntry;
import com.oksana.carsproduction.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public AccountingEntry mapToEntity(AccountDto accountDto){
        AccountingEntry result = this.modelMapper.map(accountDto, AccountingEntry.class);
        result.setUser(this.userService.findById(accountDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User was not found")));
        return result;
    }

    public AccountDto mapToDto(AccountingEntry accountingEntry){

        AccountDto result = this.modelMapper.map(accountingEntry, AccountDto.class);
        result.setUserId(this.userService.findById(accountingEntry.getUser().getId())
                .orElseThrow(()-> new RuntimeException("User was not found")));
        return result;
    }
}
