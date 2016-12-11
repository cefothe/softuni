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

    @Column(name = "max_aperture")
    private double  maxAperture;

    @Column(name = "compatible_with")
    private String compatibleWith;


    public Lens() {
    }
    public Lens(String make, int focalLength, double maxAperture, String compatibleWith) {
        this.make = make;
        this.focalLength = focalLength;
        this.maxAperture = maxAperture;
        this.compatibleWith = compatibleWith;

    }

    public double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
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

    @Override
    public String toString() {
        return getMake() + getFocalLength()+"mm f" +getMaxAperture();
    }
}
