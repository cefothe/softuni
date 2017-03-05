package entities.game;

import entities.common.BaseEntityAdapter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static entities.game.Game.FIND_ALL_GAMES;

/**
 * Created by cefothe on 05.03.17.
 */
@NamedQueries({
        @NamedQuery(name =FIND_ALL_GAMES , query = "SELECT g from Game g"),
})
@Entity
@Table(name="games")
public class Game extends BaseEntityAdapter implements Serializable{

    public static final String FIND_ALL_GAMES ="findAllGames";

    private String title;

    private String trailer;

    private String imageThumbnail;

    private Double size;

    private Double price;

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

    public Game(){

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
