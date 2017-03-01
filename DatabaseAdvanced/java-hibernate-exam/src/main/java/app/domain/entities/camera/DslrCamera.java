package app.domain.entities.camera;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by cefothe on 11.12.16.
 */
@Entity
@DiscriminatorValue(value = "DSLR_CAMERA")
public class DslrCamera extends  Camera {

    @Column(name = "max_shutter_speed")
    private int maxShutterSpeed;

    public DslrCamera() {
    }

    public DslrCamera(String make, String model, boolean isFullFrame, int minIso, int maxIso, int maxShutterSpeed) {
        super(make, model, isFullFrame, minIso, maxIso);
        this.setMaxShutterSpeed(maxShutterSpeed);
    }

    public int getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }

    @Override
    public String toString() {
        return "DSLR "+ super.toString();
    }
}
