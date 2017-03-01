package app.console;

import app.domain.Major;
import app.domain.Student;
import app.service.MajorService;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by cefothe on 09.12.16.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Override
    public void run(String... strings) throws Exception {
        Major major = new Major("IT");
        Student student = new Student("Jonh", "A.", new Date(),major);

        this.majorService.create(major);
        this.studentService.register(student);

        List<String> studentNames = Arrays.asList("Jonh", "Pesho");

        List<Student> students= this.studentService.findByFirstName(studentNames);
        students.stream().forEach(x->{
            System.out.println(x.getFirstName());
        });
    }
}
