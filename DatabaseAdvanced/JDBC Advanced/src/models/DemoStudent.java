package models;

import dao.imp.StudentDaoImp;
import dao.interfaces.StudentDao;

/**
 * Created by cefothe on 07.12.16.
 */
public class DemoStudent {

    public static void main(String[] args) {
        try(StudentDao studentDao =new StudentDaoImp()) {
//            Student student = new Student(19,"Stefan");
//            studentDao.insertStudent(student);
//
            //studentDao.updateStudent(new Student(19, "Ivan"));

            for (Student student : studentDao.getAllStudents()){
                System.out.println(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
