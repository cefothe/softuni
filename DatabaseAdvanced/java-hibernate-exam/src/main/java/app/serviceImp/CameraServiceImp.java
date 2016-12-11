package app.serviceImp;

import app.domain.dto.json.CameraDTO;
import app.domain.entities.camera.Camera;
import app.domain.factory.CameraFactory;
import app.io.interfaces.ConsoleIO;
import app.repositories.CameraRepository;
import app.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
@Service
public class CameraServiceImp implements CameraService{

    @Autowired
    private CameraFactory cameraFactory;

    @Autowired
    private CameraRepository cameraRepository;


    @Autowired
    private ConsoleIO consoleIO;

    @Override
    public void create(CameraDTO cameraDTO) {
        Camera camera = null;
        try{
            camera= cameraFactory.create(cameraDTO);
        }catch (IllegalArgumentException ex){
            consoleIO.write("Error. Invalid data provided");
            camera = null;
        }
        if(camera !=null){
            cameraRepository.saveAndFlush(camera);
            consoleIO.write("Successfully imported "+ camera.toString());
        }
    }

    @Override
    public List<Camera> findAll() {
        return cameraRepository.findAll();
    }
}
