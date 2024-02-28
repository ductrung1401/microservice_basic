package com.trungtd.employeeservice.controller;

import com.trungtd.employeeservice.model.AddEmployeeDepartment;
import com.trungtd.employeeservice.service.EmployeeService;
import com.trungtd.employeeservice.service.EmployeeServiceIpml;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;
    private final EmployeeServiceIpml employeeServiceIpml;

//    @GetMapping("/department/{departmentId}")
//    public ResponseEntity<?> findByDepartment(@PathVariable Long departmentId) {
//
//    }

    @PostMapping("/add-to-department")
    public ResponseEntity<?> addToDepartment(@RequestBody AddEmployeeDepartment req) {
        return ResponseEntity.ok(employeeServiceIpml.addEmployee(req));
    }
}
