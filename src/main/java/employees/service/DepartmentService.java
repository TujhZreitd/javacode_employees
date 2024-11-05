package employees.service;

import employees.model.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);
    Department findById(int id);
    List<Department> findAll();
    void update(Department department);
    void deleteById(int id);
}
