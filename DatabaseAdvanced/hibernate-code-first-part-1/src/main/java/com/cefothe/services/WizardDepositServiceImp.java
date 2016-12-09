package com.cefothe.services;

import com.cefothe.entities.WizardDeposit;
import com.cefothe.repositories.WizardDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by cefothe on 10.12.16.
 */
@Service
public class WizardDepositServiceImp implements  WizardDepositService {

    @Autowired
    private WizardDepositRepository wizardDepositRepository;

    @Override
    public void persist(WizardDeposit wizardDeposit) {
        this.wizardDepositRepository.saveAndFlush(wizardDeposit);
    }

    @Override
    public List<WizardDeposit> findAll() {
        return Collections.unmodifiableList(wizardDepositRepository.findAll());

    }
}
