package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by cefothe on 09.12.16.
 */
@Entity
    @Table(name = "majors")
public class Major implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "major")
    private List<Student> students;

    public Major() {
    }

    public Major(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
