package app.domain.dto.xml;

import app.domain.entities.workshop.Workshop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsDTO {

    @XmlElement(name = "workshop")
    List<WorkshopDTO> workshops;


    public List<WorkshopDTO> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<WorkshopDTO> workshops) {
        this.workshops = workshops;
    }
}
