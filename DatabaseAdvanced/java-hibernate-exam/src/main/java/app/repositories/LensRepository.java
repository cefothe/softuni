package app.repositories;

import app.domain.entities.lens.Lens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cefothe on 11.12.16.
 */
@Repository
@Transactional
public interface LensRepository extends JpaRepository<Lens, Long> {
}
