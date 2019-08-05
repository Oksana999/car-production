package com.oksana.carsproduction.repositories;

import com.oksana.carsproduction.entity.AccountingEntry;
import com.oksana.carsproduction.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends Repository<AccountingEntry> {

    public Optional<AccountingEntry> findByUserId(Long userId);

    public List<AccountingEntry> findAllByUser (User user);

    public List<AccountingEntry> findAllByUserAndDateBefore (User user, LocalDateTime dateTime);

}
