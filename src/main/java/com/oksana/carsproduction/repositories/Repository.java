package com.oksana.carsproduction.repositories;

import com.oksana.carsproduction.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
