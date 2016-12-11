package app.terminal;

import app.configuration.Configuration;
import app.domain.dto.json.CameraDTO;
import app.domain.dto.json.LensDTO;
import app.domain.dto.json.PhotographerDTO;
import app.domain.dto.xml.AccessoriesDTO;
import app.domain.entities.camera.Camera;
import app.io.interfaces.ConsoleIO;
import app.parser.interfaces.FileParser;
import app.service.CameraService;
import app.service.LensService;
import app.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "JSONParser")
    private FileParser jsonParser;

    @Autowired
    @Qualifier(value = "XMLParser")
    private FileParser xmlParser;

    @Autowired
    private ConsoleIO consoleIO;

    @Autowired
    private LensService lensService;

    @Autowired
    private CameraService cameraService;

    @Autowired
    private PhotographerService photographerService;

    @Override
    public void run(String... strings) throws Exception {
        importLensFromJSON();
        importCameraFromJSON();
        importPhotographerFROMJSON();
        importAccessoriesFromXML();
    }

    private void importLensFromJSON(){
        LensDTO[] lensDTO = null;
        try {
            lensDTO = this.jsonParser.read(LensDTO[].class, Configuration.LENS_JSON_INPUT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(LensDTO lens : lensDTO){
            lensService.create(lens);
        }

    }

    private void importCameraFromJSON(){
        CameraDTO[] cameraDTO = null;
        try {
            cameraDTO = this.jsonParser.read(CameraDTO[].class, Configuration.CAMERAS_JSON_INPUT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(CameraDTO camera : cameraDTO){
            cameraService.create(camera);
        }
    }

    private void importPhotographerFROMJSON(){
        PhotographerDTO[] photographerDTO = null;
        List<Camera>  cameras = cameraService.findAll();
        try {
            photographerDTO = this.jsonParser.read(PhotographerDTO[].class, Configuration.PHOTOGRAPHERS_JSON_INPUT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(PhotographerDTO photographer : photographerDTO){
            photographerService.create(photographer,cameras);
        }

    }

    private void importAccessoriesFromXML(){
        AccessoriesDTO  accessoriesDTO = null;
        try {
            accessoriesDTO = this.xmlParser.read(AccessoriesDTO.class, Configuration.ACCESSORIES_XML_INPUT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}