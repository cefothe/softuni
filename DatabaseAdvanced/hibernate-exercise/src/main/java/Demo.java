import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by cefothe on 09.12.16.
 */
public class Demo {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("softuni");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employeeManager = entityManager.find(Employee.class,5);
        Department department = new Department("Text",employeeManager);

        Town town = new Town("Burgas");

        Address address = new Address("City center", town);

        Project project = new Project("Awesome Project","very Awesome", new Date(), new Date());

        Employee employee  = new Employee();
        employee.setFirstName("John");
        employee.setMiddleName("A.");
        employee.setLastName("Smith");
        employee.setJobTitle("Master Trainer");
        employee.setSalary(new BigDecimal("10000"));
        employee.setAddress(address);
        employee.setHireDate(new Date());
        employee.setDepartment(department);
        Employee employeeManagerJonh = entityManager.find(Employee.class, 1);
        employee.setManager(employeeManagerJonh);
        employee.setProjects(new ArrayList<>());

        employee.getProjects().add(project);

        entityManager.persist(department);
        entityManager.persist(town);
        entityManager.persist(address);
        entityManager.persist(project);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();


    }
}
