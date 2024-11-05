package employees.service;

import employees.model.Employee;
import employees.projection.EmployeeProjection;

import java.util.List;

public interface EmployeeService {
    EmployeeProjection save(Employee employee);
    EmployeeProjection findById(int id);
    List<EmployeeProjection> findAll();
    void update(Employee employee);
    void deleteById(int id);
}
