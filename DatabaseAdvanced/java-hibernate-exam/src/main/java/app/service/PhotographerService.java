package app.service;

import app.domain.dto.json.PhotographerDTO;
import app.domain.entities.camera.Camera;
import app.domain.entities.ptotographer.Photographer;

import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
public interface PhotographerService {
    void create(PhotographerDTO photographerDTO,List<Camera> cameras);
    List<Photographer> findAll();
    List<PhotographerDTO> findAllOrderByFirstNameAndLastName();
}
