package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testSaveDepartment() {
        // Create a sample department
        Department department = new Department();
        department.setName("IT");

        // Send a POST request to save the department
        ResponseEntity<Department> responseEntity = restTemplate.postForEntity("/departments", department, Department.class);

        // Verify that the department was saved successfully
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getId()).isNotNull();

        // Clean up: Delete the department from the database
        departmentRepository.deleteById(responseEntity.getBody().getId());
    }
}
