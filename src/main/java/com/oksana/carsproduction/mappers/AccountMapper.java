package com.oksana.carsproduction.mappers;

import com.oksana.carsproduction.dtos.AccountDto;
import com.oksana.carsproduction.entity.AccountingEntry;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final ModelMapper modelMapper;

    public AccountingEntry mapToEntity(AccountDto accountDto){
       return this.modelMapper.map(accountDto, AccountingEntry.class );
    }

    public AccountDto mapToDto(AccountingEntry accountingEntry){
        return this.modelMapper.map(accountingEntry, AccountDto.class);
    }
}
