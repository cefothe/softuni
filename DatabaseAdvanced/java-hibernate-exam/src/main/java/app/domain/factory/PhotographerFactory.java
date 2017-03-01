package app.domain.factory;

import app.domain.dto.json.PhotographerDTO;
import app.domain.entities.ptotographer.Photographer;

/**
 * Created by cefothe on 11.12.16.
 */
public class PhotographerFactory {

    public Photographer create(PhotographerDTO photographerDTO){
        if(photographerDTO.getLastName()== null || photographerDTO.getFirstName()==null){
            throw  new IllegalArgumentException();
        }

        Photographer photographer = new Photographer();
        photographer.setFirstName(photographerDTO.getFirstName());
        photographer.setLastName(photographerDTO.getLastName());
        photographer.setPhone(photographerDTO.getPhone());
        return photographer;
    }
}
