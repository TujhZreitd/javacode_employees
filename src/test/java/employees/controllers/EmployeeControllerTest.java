package employees.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import employees.model.Department;
import employees.model.Employee;
import employees.projection.EmployeeProjection;
import employees.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private EmployeeService employeeService;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee(1, "Egor", "Yakushev", "Java Developer", new BigDecimal(100000), new Department(1, "It"));
    }

    @Test
    public void whenRequestGetAllEmployees() throws Exception {
        String json = "{ \"firstName\": \"Egor\", \"lastName\": \"Yakushev\", \"position\": \"Java Developer\", \"salary\": 100000, \"department\": { \"id\" : 1} }";
        when(employeeService.save(any(Employee.class))).thenReturn(new EmployeeProjection() {
            @Override
            public String getFullName() {
                return "Egor Yakushev";
            }

            @Override
            public String getPosition() {
                return "Java Developer";
            }

            @Override
            public String getDepartmentName() {
                return "It";
            }
        });

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Egor Yakushev"));
    }

}