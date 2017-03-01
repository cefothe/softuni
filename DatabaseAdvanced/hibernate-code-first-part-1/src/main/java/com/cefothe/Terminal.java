package com.cefothe;

import com.cefothe.entities.WizardDeposit;
import com.cefothe.services.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by cefothe on 10.12.16.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private WizardDepositService wizardDepositService;

    @Override
    public void run(String... strings) throws Exception {
        WizardDeposit wizardDeposit = new WizardDeposit();
        wizardDeposit.setFirstName("Teo aaaa");
        wizardDeposit.setLastName("Dimitrov");
        wizardDeposit.setAge(26);
        wizardDeposit.setMagicWandCreator("TatkO");
        wizardDeposit.setMagicWandSize(26);
        wizardDeposit.setDepositAmount(0.0);
        wizardDeposit.setDepositCharge(0.0);
        wizardDeposit.setDepositInterest(10.0);
        wizardDeposit.setDepositExpirationDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,11,12);
        wizardDeposit.setDepositStartDate(calendar.getTime());
        wizardDeposit.setDepositExpired(false);

        WizardDeposit newTeo = new WizardDeposit();
        newTeo.setFirstName("Teo Calendar2");
        newTeo.setLastName("Dimitrov");
        newTeo.setAge(26);
        newTeo.setMagicWandCreator("TatkO");
        newTeo.setMagicWandSize(26);
        newTeo.setDepositAmount(0.0);
        newTeo.setDepositCharge(0.0);
        newTeo.setDepositInterest(10.0);
        newTeo.setDepositExpirationDate(new Date());
        calendar = Calendar.getInstance();
        calendar.set(2016,11,12);
        newTeo.setDepositStartDate(calendar.getTime());
        newTeo.setDepositExpired(true);

        this.wizardDepositService.persist(newTeo);
        this.wizardDepositService.persist(wizardDeposit);

        this.wizardDepositService.findAll().stream().forEach(x -> {System.out.println(x.getFirstName());});

    }
}
