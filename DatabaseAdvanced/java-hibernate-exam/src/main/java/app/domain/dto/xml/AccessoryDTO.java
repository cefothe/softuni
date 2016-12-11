package app.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by cefothe on 11.12.16.
 */
@XmlRootElement(name = "accessory")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryDTO {

    @XmlAttribute(name = "name")
    private String name;

    public AccessoryDTO() {
    }
}
