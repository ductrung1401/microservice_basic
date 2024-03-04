package com.trungtd.departmentservice.client;

import com.trungtd.departmentservice.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service", url = "${application.config.employee-url}")
public interface EmployeeClient {
    @GetMapping("/department/{departmentId}")
    List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId);
}
