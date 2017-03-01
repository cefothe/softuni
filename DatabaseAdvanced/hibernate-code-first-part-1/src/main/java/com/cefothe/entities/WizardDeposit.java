package com.cefothe.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cefothe on 09.12.16.
 */

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 60)
    private String lastName;

    @Column(columnDefinition = "TEXT" ,length = 10000)
    private String notes;

    @Column(columnDefinition = "INT UNSIGNED")
    private Integer age;

    @Column(length = 100)
    private String magicWandCreator;

    @Column(columnDefinition = "TINYINT UNSIGNED")
    private Integer magicWandSize;

    @Column(length = 20)
    private String  depositGroup;

    @Column(columnDefinition = "DATETIME")
    private Date depositStartDate;

    @Basic
    private Double depositAmount;

    @Basic
    private Double depositInterest;

    @Basic
    private Double depositCharge;

    @Basic
    private Date depositExpirationDate;

    @Basic
    private Boolean isDepositExpired;

    public WizardDeposit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public Integer getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(Integer magicWandSize) {
        if(magicWandSize > 0 && magicWandSize < (32_678)){

            this.magicWandSize = magicWandSize;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public Date getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(Date depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(Double depositInterest) {
        this.depositInterest = depositInterest;
    }

    public Double getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(Double depositCharge) {
        this.depositCharge = depositCharge;
    }

    public Date getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(Date depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public Boolean getDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(Boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
