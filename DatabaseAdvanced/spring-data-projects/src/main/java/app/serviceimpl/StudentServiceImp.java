package app.serviceimpl;

import app.dao.StudentDao;
import app.domain.Student;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cefothe on 09.12.16.
 */
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void register(Student student) {
        this.studentDao.saveAndFlush(student);
    }

    @Override
    public void expel(Student student) {
        this.studentDao.delete(student);
    }

    @Override
    public Student find(long id) {
        return this.studentDao.findOne(id);
    }

    @Override
    public List<Student> findByFirstName(List<String> firstNames) {
        return  this.studentDao.findByFirstNameIn(firstNames);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return  this.studentDao.findByFirstName(firstName);
    }
}
