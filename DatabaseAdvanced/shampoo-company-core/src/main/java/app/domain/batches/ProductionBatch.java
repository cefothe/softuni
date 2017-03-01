package app.domain.batches;

import app.domain.shampoos.BasicShampoo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by cefothe on 10.12.16.
 */
@Entity
@Table(name =  "production_batches")
public class ProductionBatch implements  Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "batch_date")
    private Date batchDate;

    @OneToMany(mappedBy = "batch", targetEntity = BasicShampoo.class)
    private Set<BasicShampoo> shampoos;

    public ProductionBatch() {
    }

    public ProductionBatch(Date batchDate, Set<BasicShampoo> shampoos) {
        this.batchDate = batchDate;
        this.shampoos = shampoos;
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
    public Date getBatchDate() {
        return batchDate;
    }

    @Override
    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    @Override
    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    @Override
    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
