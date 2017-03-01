package app.domain.entities.workshop;

import app.domain.entities.common.EntityAdapter;
import app.domain.entities.ptotographer.Photographer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by cefothe on 11.12.16.
 */

@Entity
@Table(name = "worshops")
public class Workshop extends EntityAdapter {

    @Column(nullable = false)
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "trainer_id",referencedColumnName = "id", nullable = false)
    private Photographer trainer;


    @ManyToMany
    @JoinTable(name = "photographers_workshop",
            joinColumns =  @JoinColumn(name = "worshop_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "photographer_id", referencedColumnName = "id"))
    private Set<Photographer> photographers;

    public Workshop() {
    }

    public Workshop(String name, Date startDate, Date endDate, String location, BigDecimal price, Photographer photographer, Set<Photographer> photographers) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.price = price;
        this.trainer = photographer;
        this.photographers = photographers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Photographer getTrainer() {
        return trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    public Set<Photographer> getPhotographers() {
        return photographers;
    }

    public void setPhotographers(Set<Photographer> photographers) {
        this.photographers = photographers;
    }
}
