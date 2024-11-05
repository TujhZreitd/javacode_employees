package employees.repository;

import employees.model.Employee;
import employees.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<EmployeeProjection> findAllProjectedBy();
    Optional<EmployeeProjection> findProjectedById(int id);
}
