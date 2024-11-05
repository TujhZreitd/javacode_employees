package employees.service;

import employees.model.Employee;
import employees.projection.EmployeeProjection;
import employees.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeProjection save(Employee employee) {
        int id = employeeRepository.save(employee).getId();
        return employeeRepository.findProjectedById(id).orElseThrow(() -> new RuntimeException("Employee not created"));
    }

    @Override
    public EmployeeProjection findById(int id) {
        return employeeRepository.findProjectedById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeProjection> findAll() {
        return employeeRepository.findAllProjectedBy();
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.findById(employee.getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.deleteById(id);
    }
}
