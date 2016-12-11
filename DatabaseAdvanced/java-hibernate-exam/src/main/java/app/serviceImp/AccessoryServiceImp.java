package app.serviceImp;

import app.domain.dto.xml.AccessoryDTO;
import app.domain.entities.accessories.Accessory;
import app.domain.entities.camera.Camera;
import app.domain.entities.ptotographer.Photographer;
import app.domain.factory.AccessoryFactory;
import app.io.interfaces.ConsoleIO;
import app.repositories.AccessoryRepository;
import app.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by cefothe on 11.12.16.
 */
@Service
public class AccessoryServiceImp implements AccessoryService {

    @Autowired
    private AccessoryFactory accessoryFactory;

    @Autowired
    private AccessoryRepository accessoryRepository;


    @Autowired
    private ConsoleIO consoleIO;

    @Override
    public void create(AccessoryDTO accessoryDTO, List<Photographer> photographers) {
        Accessory accessory =accessoryFactory.create(accessoryDTO);
        Photographer photographer = randomPhotographer(photographers);
        accessory.setOwner(photographer);
        accessoryRepository.saveAndFlush(accessory);
        consoleIO.write("Successfully imported"+ accessory.toString());


    }

    private Photographer randomPhotographer(List<Photographer> cameras){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(cameras.size());
        Photographer item = cameras.get(index);
        return item;
    }
}
