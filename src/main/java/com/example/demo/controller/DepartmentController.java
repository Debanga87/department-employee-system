package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("/employee-count")
    public Map<String, Long> getEmployeeCountPerDepartment() {
        List<Object[]> results = departmentRepository.getEmployeeCountPerDepartment();
        return results.stream()
                .collect(Collectors.toMap(
                        array -> (String) array[0],
                        array -> (Long) array[1]
                ));
    }
}
