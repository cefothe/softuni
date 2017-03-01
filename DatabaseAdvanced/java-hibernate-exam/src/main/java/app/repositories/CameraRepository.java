package app.repositories;

/**
 * Created by cefothe on 11.12.16.
 */

import app.domain.entities.camera.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CameraRepository extends JpaRepository<Camera, Long>{
}
