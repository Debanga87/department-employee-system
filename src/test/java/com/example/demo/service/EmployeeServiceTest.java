package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

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

        // Create a sample departmentId
        Long departmentId = 1L;

        // Mock the save method of the repository
        when(employeeRepository.save(employee)).thenReturn(employee);

        // Call the service method
        Employee savedEmployee = employeeService.save(employee, departmentId);

        // Verify that the save method of the repository was called
        verify(employeeRepository).save(employee);
    }
}
