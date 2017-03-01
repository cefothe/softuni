package app.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by cefothe on 11.12.16.
 */
@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopDTO {

    @XmlAttribute(name = "name")
    public String name;

    @XmlAttribute(name = "start-date")
    public Date startDate;

    @XmlAttribute(name = "end-date")
    public Date endDate;

}
