package session;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cefothe on 02.03.17.
 */
public class Session implements Serializable{

    private long id;

    private Map<String,String> pairs;

    private Date createdOn;

    private Date expiresOn;

    public Session(long id) {
        this.id = id;
        this.pairs = new HashMap<String, String>();
        this.createdOn = new Date();
        this.expiresOn = new Date(createdOn.getTime() + 1 * 24 * 60 * 60 * 1000);
    }


}
