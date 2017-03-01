package app.dao;

import app.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cefothe on 09.12.16.
 */
@Repository
@Transactional
public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameIn(List<String> firstNames);

    List<Student> findByFirstName(String firstName);
}
