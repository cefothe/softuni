package app.domain.labels;

import app.domain.shampoos.BasicShampoo;

import javax.persistence.*;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@Table(name = "labels")
public class ClassicLabel implements  Label {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String title;

    @Basic
    private String subTitle;

    @OneToOne(mappedBy = "label", targetEntity = BasicShampoo.class)
    private BasicShampoo basicShampoo;

    public ClassicLabel() {
    }

    public ClassicLabel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubTitle() {
        return subTitle;
    }

    @Override
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
