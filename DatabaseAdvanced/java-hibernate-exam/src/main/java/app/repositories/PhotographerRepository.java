package app.repositories;

import app.domain.entities.ptotographer.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cefothe on 11.12.16.
 */
@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {

    @Query(value = "SELECT p FROM Photographer as p ORDER BY p.firstName ASC, p.lastName DESC")
    List<Photographer> findAllOrderByFirstNameAndLastNameDesc();
}
