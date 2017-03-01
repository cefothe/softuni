package app.domain.factory;

import app.domain.dto.xml.AccessoryDTO;
import app.domain.entities.accessories.Accessory;

/**
 * Created by cefothe on 11.12.16.
 */
public class AccessoryFactory {

    public Accessory create(AccessoryDTO accessoryDTO){
        Accessory accessory = new Accessory();
        accessory.setName(accessoryDTO.getName());
        return  accessory;
    }
}
