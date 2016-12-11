package app.service;

import app.domain.dto.json.CameraDTO;
import app.domain.entities.camera.Camera;

import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
public interface CameraService {
    void create(CameraDTO cameraDTO);
    List<Camera> findAll();
}
