package com.cefothe.services;

import com.cefothe.entities.WizardDeposit;

import java.util.List;

/**
 * Created by cefothe on 10.12.16.
 */
public interface WizardDepositService {
    void persist(WizardDeposit wizardDeposit);
    List<WizardDeposit> findAll();
}
