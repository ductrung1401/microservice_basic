package com.trungtd.employeeservice.controller;

import com.trungtd.employeeservice.model.AddEmployeeDepartment;
import com.trungtd.employeeservice.model.Employee;
import com.trungtd.employeeservice.service.EmployeeServiceIpml;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

//    private final EmployeeService employeeService;
    private final EmployeeServiceIpml employeeServiceIpml;

//    @GetMapping("/department/{departmentId}")
//    public ResponseEntity<?> findByDepartment(@PathVariable Long departmentId) {
//
//    }
    @PostMapping("/add-employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceIpml.addEmployee(employee));
    }

    @GetMapping("")
    public ResponseEntity<?> getEmployee() {
        List<Employee> employeeList = employeeServiceIpml.getAllEmployee();
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeServiceIpml.getEmployeeById(id));
    }
    @PostMapping("/add-to-department")
    public ResponseEntity<?> addToDepartment(@RequestBody AddEmployeeDepartment req) {
        return ResponseEntity.ok(employeeServiceIpml.addEmployeeToDepartment(req));
    }
}
