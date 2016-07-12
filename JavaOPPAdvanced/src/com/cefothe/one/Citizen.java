package com.cefothe.one;

/**
 * Created by cefothe on 12.07.16.
 */
public class Citizen implements Person, Birthable,Identifiable {

    private String name;
    private int age;
    private String id;
    private String birthdate;


    public Citizen(String name, int age, String id, String birthdate){
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public String getId() {
        return id;
    }
}
