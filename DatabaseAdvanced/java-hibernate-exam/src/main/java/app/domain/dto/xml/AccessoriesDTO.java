package app.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesDTO {

    @XmlElement(name = "accessory")
    List<AccessoryDTO> accessoryDTO;

    public AccessoriesDTO() {
        accessoryDTO = new ArrayList<>();
    }

    public AccessoriesDTO(List<AccessoryDTO> accessoryDTO) {
        this.accessoryDTO = accessoryDTO;
    }

    public List<AccessoryDTO> getAccessoryDTO() {
        return accessoryDTO;
    }

    public void setAccessoryDTO(List<AccessoryDTO> accessoryDTO) {
        this.accessoryDTO = accessoryDTO;
    }
}
