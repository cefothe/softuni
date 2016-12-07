package models;

import persistance.Column;
import persistance.Entity;
import persistance.Id;

import java.util.Date;

/**
 * Created by cefothe on 07.12.16.
 */
@Entity(name = "user")
public class User {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name = "registastation_date")
    private Date registrationDate;

    @SuppressWarnings("unused")
    public User() {
    }

    public User(String name, int age, Date registrationDate) {
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
