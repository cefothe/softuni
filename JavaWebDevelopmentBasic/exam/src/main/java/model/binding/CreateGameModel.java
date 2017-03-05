package model.binding;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cefothe on 05.03.17.
 */
public class CreateGameModel {

    @Size(min = 3)
    @Pattern(regexp = "^[A-Z].{3,100}$", message = "The name of game should be start with capital letter")
    private String title;


    private BigDecimal prize;

    @Pattern(regexp = "^([0-9]+.[0-9]{0,1})$", message ="Size is incorrect")
    private String size;

    @Size(min = 11, max = 11, message = "Trailer should be have excatly 11 symbol")
    private String trailer;

    @Pattern(regexp = "^(https?|ftp):\\/\\/(.*)$", message = "Incorrect url")
    private String imageThumbnail;

    @Size(min = 20)
    private String description;

    private String releaseDate;

    public CreateGameModel() {
    }

    public CreateGameModel(String title, BigDecimal prize, String size, String trailer, String imageThumbnail, String description, String releaseDate) {
        this.title = title;
        this.prize = prize;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
