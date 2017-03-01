package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cefothe on 09.12.16.
 */
@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "registation_date")
    private Date registationDate;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    public Student() {
    }

    public Student(String firstName, String lastName, Date registationDate, Major major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registationDate = registationDate;
        this.major = major;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getRegistationDate() {
        return registationDate;
    }

    public void setRegistationDate(Date registationDate) {
        this.registationDate = registationDate;
    }
}
