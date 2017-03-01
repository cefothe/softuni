package app.domain.entities.camera;

import app.domain.entities.common.EntityAdapter;

import javax.persistence.*;

/**
 * Created by cefothe on 11.12.16.
 */
@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "camera_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Camera extends EntityAdapter {

    @Column(nullable = false)
    private  String make;

    @Column(nullable = false)
    private String model;

    @Column(name = "is_full_frame" )
    private boolean isFullFrame;

    @Column(name = "min_iso" ,nullable = false)
    private int minIso;

    @Column(name = "max_iso")
    private int maxIso;

    protected Camera() {
    }

    protected Camera(String make, String model, boolean isFullFrame, int minIso, int maxIso) {
        this.setMake(make);
        this.setModel(model);
        this.setFullFrame(isFullFrame);
        this.setMinIso(minIso);
        this.setMaxIso(maxIso);
    }

    public int getMaxIso() {
        return maxIso;
    }

    public void setMaxIso(int maxIso) {
        this.maxIso = maxIso;
    }

    public int getMinIso() {
        return minIso;
    }

    public void setMinIso(int minIso) {
        if(minIso <100 ){
            throw  new IllegalArgumentException("Min ISO cannot be lower that 100");
        }
        this.minIso = minIso;
    }

    public boolean isFullFrame() {
        return isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return this.getMake() +" "+ this.getModel();
    }
}
