package employees.service;

import employees.model.Department;
import employees.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleDepartmentService implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void update(Department department) {
        departmentRepository.findById(department.getId()).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(int id) {
        departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepository.deleteById(id);
    }
}
