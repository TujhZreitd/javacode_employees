package employees.controllers;

import employees.model.Department;
import employees.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentsController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.findById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department) {
        departmentService.save(department);
        return ResponseEntity.ok("Operation complete");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
        departmentService.deleteById(id);
        return ResponseEntity.ok("Operation complete");
    }
}
