package app.domain.entities.accessories;

import app.domain.entities.ptotographer.Photographer;
import app.domain.entities.common.EntityAdapter;

import javax.persistence.*;

/**
 * Created by cefothe on 11.12.16.
 */
@Entity
@Table(name = "accessories")
public class Accessory extends EntityAdapter{

    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "protographer_id",referencedColumnName = "id")
    private Photographer owner;

    public Accessory() {
    }

    public Accessory(String name, Photographer owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return name;
    }
}
