package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testSaveEmployee() {
        // Create a sample employee
        Employee employee = new Employee();
        employee.setName("John Doe");

        // Mock the save method of the repository
        when(employeeRepository.save(employee)).thenReturn(employee);

        // Call the service method
        employeeService.save(employee);

        // Verify that the save method of the repository was called
        verify(employeeRepository).save(employee);
    }
}
