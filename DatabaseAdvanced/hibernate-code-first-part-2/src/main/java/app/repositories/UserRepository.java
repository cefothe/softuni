package app.repositories;

import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cefothe on 10.12.16.
 */
@Repository
@Transactional
public interface UserRepository  extends JpaRepository<User, Long>{
}
