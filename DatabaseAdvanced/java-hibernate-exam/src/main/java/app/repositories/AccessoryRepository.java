package app.repositories;

import app.domain.entities.accessories.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 11.12.16.
 */
@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
}
