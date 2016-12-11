package app.repositories;

import app.domain.entities.ptotographer.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 11.12.16.
 */
@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {
}
