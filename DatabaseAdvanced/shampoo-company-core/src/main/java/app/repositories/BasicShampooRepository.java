package app.repositories;

import app.domain.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cefothe on 10.12.16.
 */
@Repository
public interface BasicShampooRepository extends JpaRepository<BasicShampoo, Long> {
}
