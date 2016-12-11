package app.domain.entities.ptotographer;

import app.domain.entities.lens.Lens;
import app.domain.entities.accessories.Accessory;
import app.domain.entities.camera.Camera;
import app.domain.entities.common.EntityAdapter;
import app.domain.entities.workshop.Workshop;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cefothe on 11.12.16.
 */
@Entity
@Table(name = "photographers")
public class Photographer extends EntityAdapter {

    @Column(name = "first_name" , nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable =  false)
    private String lastName;

    @Basic
    private String phone;

    @ManyToOne
    private Camera primaryCamera;

    @ManyToOne
    private Camera secondaryCamera;

    @ManyToMany
    private Set<Lens> lenses;

    @OneToMany
    private Set<Accessory> accessories;

    @ManyToMany(mappedBy = "photographers", targetEntity = Workshop.class)
    private Set<Workshop> workshops;

    @OneToMany(mappedBy = "trainer", targetEntity = Workshop.class)
    private Set<Workshop> trainerWorkshops;


    public Photographer() {
        this.lenses= new HashSet<>();
        this.accessories = new HashSet<>();
        this.workshops = new HashSet<>();
        this.trainerWorkshops = new HashSet<>();
    }

    public Photographer(String firstName, String lastName, String phone, Camera primaryCamera,
                        Camera secondaryCamera, Set<Lens> lenses, Set<Accessory> accessories) {
        this();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setPrimaryCamera(primaryCamera);
        this.setSecondaryCamera(secondaryCamera);
        this.setLenses(lenses);
        this.setAccessories(accessories);
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
        if(!(lastName.length()>=2 && lastName.length()<=50)){
            throw  new IllegalArgumentException("Last name should be required to characters between 2 and 50 characters,");
        }
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(!(phone!= null && phone.matches("\\+[0-9]{1,3}\\/[0-9]{8,10}"))){
            this.phone = null;
        }
        this.phone = phone;
    }

    public Camera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public Camera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(Camera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Set<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(Set<Lens> lenses) {
        this.lenses = lenses;
    }

    public Set<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " +this.getLastName() + "| Lenses:"+ this.getLenses().size();
    }
}
