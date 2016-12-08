package entities;

import javax.persistence.*;

/**
 * Created by cefothe on 08.12.16.
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
}
