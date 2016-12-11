package app.serviceImp;

import app.domain.dto.json.PhotographerDTO;
import app.domain.entities.camera.Camera;
import app.domain.entities.lens.Lens;
import app.domain.entities.ptotographer.Photographer;
import app.domain.factory.PhotographerFactory;
import app.io.interfaces.ConsoleIO;
import app.repositories.CameraRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographerRepository;
import app.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cefothe on 11.12.16.
 */
@Service
public class PhotographerServiceImp implements PhotographerService {

    @Autowired
    private PhotographerFactory photographerFactory;

    @Autowired
    private LensRepository lensRepository;

    @Autowired
    private CameraRepository cameraRepository;

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private ConsoleIO consoleIO;

    @Override
    public void create(PhotographerDTO photographerDTO, List<Camera>  cameras ) {
        Photographer photographer = null;

        try {
            photographer = photographerFactory.create(photographerDTO);
            for(Long lensId : photographerDTO.getLenses()){
               Lens lens = lensRepository.findOne(lensId);
                if(lens!= null){
                    photographer.getLenses().add(lens);
                }
                photographer.setPrimaryCamera(randomCamera(cameras));
                photographer.setSecondaryCamera(randomCamera(cameras));
            }
        }catch (IllegalArgumentException ex){
            consoleIO.write("Error. Invalid data provided");
            photographer = null;
        }
        if(photographer!=null){
            photographerRepository.saveAndFlush(photographer);
            consoleIO.write("Successfully imported " + photographer.toString());
        }

    }

    @Override
    public List<Photographer> findAll() {
        return photographerRepository.findAll();
    }

    @Override
    public List<PhotographerDTO> findAllOrderByFirstNameAndLastName() {
        List<PhotographerDTO> photographerDTOs = new ArrayList<>();
        photographerRepository.findAllOrderByFirstNameAndLastNameDesc().stream()
                .forEach(x->{
                    PhotographerDTO photographerDTO = new PhotographerDTO();
                    photographerDTO.setFirstName(x.getFirstName());
                    photographerDTO.setLastName(x.getLastName());
                    photographerDTO.setPhone(x.getPhone());
                    photographerDTOs.add(photographerDTO);
                });
        return photographerDTOs;
    }

    private Camera randomCamera(List<Camera> cameras){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(cameras.size());
        Camera item = cameras.get(index);
        return item;
    }
}
