package entities;

import java.util.Date;

/**
 * Created by cefothe on 08.12.16.
 */
public class Student {

    private int  id;

    private String firstName;

    private Date registrationDate;

    public Student(){

    }

    public Student(String firstName, Date registrationDate) {
        this.firstName = firstName;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
