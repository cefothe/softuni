package entities.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by cefothe on 05.03.17.
 */

@MappedSuperclass
public class BaseEntityAdapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    public BaseEntityAdapter() {
    }

    public long getId() {
        return id;
    }
}
