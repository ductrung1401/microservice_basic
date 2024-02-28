package com.trungtd.employeeservice.service;

import com.trungtd.employeeservice.model.AddEmployeeDepartment;
import com.trungtd.employeeservice.model.Employee;
import com.trungtd.employeeservice.repository.EmployeeRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeServiceIpml {
    private final EmployeeRepository employeeRepository;

    public MessageResponse addEmployee(AddEmployeeDepartment req) {

        Employee employee = employeeRepository.findById(req.getEmployeeId()).orElse(null);
        if (employee != null) {
            employee.setDepartmentId(req.getDepartmentId());
            employeeRepository.save(employee);
            return MessageResponse.builder().message("SUCCESS").build();
        }
        return MessageResponse.builder().message("Employee is not exist").build();
    }

    @Builder
    public static class MessageResponse {
        @Getter
        @Setter
        private String message;
    }
}
