package app.domain.entities.camera;

import app.domain.entities.common.EntityAdapter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by cefothe on 11.12.16.
 */
@Entity
@DiscriminatorValue(value = "MIRROLESS_CAMERA")
public class MirrorlessCamera extends Camera{

    @Column(name = "max_video_resolution",columnDefinition = "TEXT")
    private String maxVideoResolution;

    @Column(name = "max_frame_rate")
    private int maxFrameRate;

    public MirrorlessCamera() {
    }

    public MirrorlessCamera(String make, String model, boolean isFullFrame, int minIso, int maxIso, String maxVideoResolution, int maxFrameRate) {
        super(make, model, isFullFrame, minIso, maxIso);
        this.maxVideoResolution = maxVideoResolution;
        this.maxFrameRate = maxFrameRate;
    }

    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public int getMaxFrameRate() {
        return maxFrameRate;
    }

    public void setMaxFrameRate(int maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }
}
