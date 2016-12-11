package app.domain.entities.lens;

import app.domain.entities.common.EntityAdapter;
import app.domain.entities.ptotographer.Photographer;

import javax.persistence.*;

/**
 * Created by cefothe on 11.12.16.
 */
@Entity
@Table(name = "lenses")
public class Lens extends EntityAdapter {

    @Basic
    private String make;

    @Column(name = "focal_lenght")
    private int focalLength;

    @Column(name = "compatible_with")
    private String compatibleWith;

    @ManyToOne
    @JoinColumn(name = "protographer_id",referencedColumnName = "id")
    private Photographer photographer;

    public Lens() {
    }

    public Lens(String make, int focalLength, String compatibleWith, Photographer photographer) {
        this.make = make;
        this.focalLength = focalLength;
        this.compatibleWith = compatibleWith;
        this.photographer = photographer;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }
}
