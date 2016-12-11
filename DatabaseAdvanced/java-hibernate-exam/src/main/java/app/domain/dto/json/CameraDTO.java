package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by cefothe on 11.12.16.
 */
public class CameraDTO implements Serializable{

    @Expose
    public String type;

    @Expose
    public String make;

    @Expose
    public String model;

    @Expose
    public boolean isFullFrame;

    @Expose
    public Integer minISO;

    @Expose
    public int maxISO;

    @Expose
    public int MaxShutterSpeed;

    @Expose
    public String maxVideoResolution;

    @Expose
    public int maxFrameRate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getFullFrame() {
        return isFullFrame;
    }

    public void setFullFrame(Boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public Integer getMinISO() {
        return minISO;
    }

    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    public int getMaxISO() {
        return maxISO;
    }

    public void setMaxISO(int maxISO) {
        this.maxISO = maxISO;
    }

    public int getMaxShutterSpeed() {
        return MaxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        MaxShutterSpeed = maxShutterSpeed;
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
