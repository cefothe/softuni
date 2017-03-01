package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by cefothe on 11.12.16.
 */
public class LensDTO implements Serializable {

    @Expose
    public String make;

    @Expose
    public int focalLength;

    @Expose
    public double maxAperture;

    @Expose
    public String compatibleWith;

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

    public double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }
}
