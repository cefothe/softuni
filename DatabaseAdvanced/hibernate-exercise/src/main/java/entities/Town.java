package entities;

import javax.persistence.*;

/**
 * Created by cefothe on 08.12.16.
 */
@Entity
@Table(name =  "tows")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id")
    private int towdId;

    @Basic
    private String name;

    protected  Town(){
    }

    public Town(String name) {
        this.name = name;
    }

    public int getTowdId() {
        return towdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
