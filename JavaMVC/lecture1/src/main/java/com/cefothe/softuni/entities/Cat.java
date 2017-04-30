package com.cefothe.softuni.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cefothe on 27.04.17.
 */
@Entity
@AllArgsConstructor
@Table(name = "cats")
public class Cat extends BaseEntity{

    @Getter
    @Setter
    private String name;
}
