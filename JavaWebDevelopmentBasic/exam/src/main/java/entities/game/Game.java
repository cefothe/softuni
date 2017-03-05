package entities.game;

import entities.common.BaseEntityAdapter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cefothe on 05.03.17.
 */
@Entity
@Table(name="games")
public class Game extends BaseEntityAdapter implements Serializable{

    private String title;

    private String trailer;

    private String imageThumbnail;

    private double size;

    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(updatable = false)
    private Date releaseDate;

    public Game(String title, String trailer, String imageThumbnail, double size, BigDecimal price, String description, Date releaseDate) {
        this.title = title;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    protected Game(){

    }

    public String getTitle() {
        return title;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public double getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}
