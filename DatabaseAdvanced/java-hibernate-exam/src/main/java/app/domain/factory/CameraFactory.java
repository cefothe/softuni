package app.domain.factory;

import app.domain.dto.json.CameraDTO;
import app.domain.entities.camera.Camera;
import app.domain.entities.camera.CameraTypes;
import app.domain.entities.camera.DslrCamera;
import app.domain.entities.camera.MirrorlessCamera;

/**
 * Created by cefothe on 11.12.16.
 */
public class CameraFactory {

    public Camera create(CameraDTO cameraDTO){
        if(cameraDTO.getType()==null || cameraDTO.getMake()==null  || cameraDTO.getModel()==null  || cameraDTO.getMinISO()== null ){
            throw new IllegalArgumentException();
        }
        if(cameraDTO.getType().equals(CameraTypes.DSLR.getJsonType())){
            return new DslrCamera(cameraDTO.getMake(),cameraDTO.getModel(),cameraDTO.getFullFrame(), cameraDTO.getMinISO(), cameraDTO.getMaxISO(),cameraDTO.getMaxShutterSpeed());
        }
        if(cameraDTO.getType().equals(CameraTypes.MIRRORLESS.getJsonType())){
            return new MirrorlessCamera(cameraDTO.getMake(),cameraDTO.getModel(),cameraDTO.getFullFrame(),cameraDTO.getMinISO(),cameraDTO.getMaxISO(),cameraDTO.getMaxVideoResolution(),cameraDTO.getMaxFrameRate());
        }

        throw  new IllegalArgumentException("This type of camera doesn't support" + cameraDTO.getType());
    }
}
