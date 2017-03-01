package app.dao;

import app.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cefothe on 09.12.16.
 */
@Repository
@Transactional
public interface ManajorDao extends JpaRepository<Major, Long> {
}
