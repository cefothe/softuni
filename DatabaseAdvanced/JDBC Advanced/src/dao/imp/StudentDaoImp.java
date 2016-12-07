package dao.imp;

import dao.connection.DatabaseConnection;
import dao.interfaces.StudentDao;
import models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cefothe on 07.12.16.
 */
public class StudentDaoImp implements StudentDao {

    private static final String SELECT = "SELECT * FROM students";

    private static final String INSERT = "INSERT INTO students (id, name) values (?,?)";

    private static final String UPDATE = "UPDATE students SET name = ? WHERE id = ?";

    private static final String DELETE = "DELETE students WHERE id = ?";

    private  List<Student> students;

    private Connection connection;

    private PreparedStatement statement;

    private ResultSet resultSet;

    public StudentDaoImp(){
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.statement = this.connection.prepareStatement(SELECT);
        this.resultSet = this.statement.executeQuery();
        while(this.resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Student student = new Student(id,name);
            this.students.add(student);
        }
        return  this.students;
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.statement = this.connection.prepareStatement(INSERT);
        this.statement.setInt(1,student.getId());
        this.statement.setString(2,student.getName());
        this.statement.execute();
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.statement = this.connection.prepareStatement(UPDATE);
        this.statement.setString(1,student.getName());
        this.statement.setInt(2,student.getId());
        this.statement.execute();

    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.statement = this.connection.prepareStatement(DELETE);
        this.statement.setInt(1,student.getId());
        this.statement.execute();

    }

    @Override
    public void close() throws Exception {
        if(this.resultSet != null){
            this.resultSet.close();
        }
        if(this.statement != null){
            this.statement.close();
        }
        if(this.connection != null){
            this.connection.close();
        }

    }
}
