package app.domain.batches;

import app.domain.shampoos.BasicShampoo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by cefothe on 10.12.16.
 */
public interface Batch extends Serializable {

    long getId();

    void setId(long id);

    Date getBatchDate();

    void setBatchDate(Date batchDate);

    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> shampoos);
}
