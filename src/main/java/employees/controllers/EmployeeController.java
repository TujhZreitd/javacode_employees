package employees.controllers;

import employees.model.Employee;
import employees.projection.EmployeeProjection;
import employees.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeProjection> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeProjection getEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeProjection addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }


}
