package com.cefothe.repositories;

import com.cefothe.entities.WizardDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cefothe on 10.12.16.
 */
@Repository
@Transactional
public interface WizardDepositRepository extends JpaRepository<WizardDeposit, Long> {

    @Override
    @Query("SELECT wizarDeposit FROM WizardDeposit AS wizarDeposit WHERE wizarDeposit.isDepositExpired = true")
    List<WizardDeposit> findAll();
}
