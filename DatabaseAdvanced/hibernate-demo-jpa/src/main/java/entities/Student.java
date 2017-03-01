package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cefothe on 08.12.16.
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    private String name;

    @Column(name = "registration_date")
    private Date registationDate;

    protected  Student(){

    }


    public Student(String name, Date registationDate) {
        this.name = name;
        this.registationDate = registationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistationDate() {
        return registationDate;
    }

    public void setRegistationDate(Date registationDate) {
        this.registationDate = registationDate;
    }

}
