package app.domain.entities.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by cefothe on 11.12.16.
 */
@MappedSuperclass
public abstract class EntityAdapter  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    public EntityAdapter() {
    }

    public long getId() {
        return id;
    }
}
