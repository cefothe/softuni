package app.service;

import app.domain.dto.xml.AccessoryDTO;
import app.domain.entities.ptotographer.Photographer;

import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
public interface AccessoryService {
    void create(AccessoryDTO accessoryDTO, List<Photographer>photographers);
}
