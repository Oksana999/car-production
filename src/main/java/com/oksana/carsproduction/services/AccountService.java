package com.oksana.carsproduction.services;

import com.oksana.carsproduction.entity.AccountingEntry;
import com.oksana.carsproduction.entity.User;
import com.oksana.carsproduction.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountingEntry create (AccountingEntry accountingEntry){
      return   this.accountRepository.save(accountingEntry);
    }

    public List<AccountingEntry> findByUser (User user){
       return this.accountRepository.findAllByUser(user);
    }

    public BigDecimal getBalance (User user, LocalDateTime localDateTime){
        List<AccountingEntry> transactions = this.accountRepository.findAllByUserAndDateBefore(user, localDateTime);

        BigDecimal allDebit = BigDecimal.ZERO;
        BigDecimal allCredit = BigDecimal.ZERO;

        for(AccountingEntry transaction : transactions){
            if(transaction.getIsDebit()){
                allDebit = allDebit.add(transaction.getAmount());
            }else{
                allCredit = allCredit.add(transaction.getAmount());
            }
        }
        return allDebit.subtract(allCredit);
    }

    public AccountingEntry findByUserId(Long userId){
        return this.accountRepository.findByUserId(userId)
                .orElseThrow(()->new RuntimeException("AccountingEntry not found"));
    }

    public List<AccountingEntry> findAllByUser(User user){
        return this.accountRepository.findAllByUser(user);
    }


    public AccountingEntry update(AccountingEntry accountingEntry){
        AccountingEntry updatedAccountingEntry = this.accountRepository.findById(accountingEntry.getId())
                .orElseThrow(()->new RuntimeException("AccountingEntry not found"));
        updatedAccountingEntry.setAmount(accountingEntry.getAmount());
        updatedAccountingEntry.setDate(accountingEntry.getDate());
        updatedAccountingEntry.setUser(accountingEntry.getUser());
        return this.accountRepository.save(updatedAccountingEntry);
    }

    public void delete (AccountingEntry accountingEntry){
        this.accountRepository.delete(accountingEntry);
    }

    public AccountingEntry findById (Long accountId){
        return this.accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("Account not found"));
    }
}
