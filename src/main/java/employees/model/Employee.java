package employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String position;

    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDepartmentName() {
        return department != null ? department.getName() : null;
    }
}
