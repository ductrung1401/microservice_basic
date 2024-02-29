package com.trungtd.employeeservice.service;

import com.trungtd.employeeservice.custom.exception.ExistsException;
import com.trungtd.employeeservice.model.AddEmployeeDepartment;
import com.trungtd.employeeservice.model.Employee;
import com.trungtd.employeeservice.repository.EmployeeRepository;
import com.trungtd.employeeservice.response.MessageResponse;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeServiceIpml {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        Optional.ofNullable(employee)
                .filter(em -> !employeeRepository.existsById(em.getId()))
                .orElseThrow(
                        () -> new ExistsException("Department cannot be null or already exists")
                );
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty())
            throw new NotFoundException("Khong ton tai employee nao trong he thong");
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new com.trungtd.employeeservice.custom.exception.NotFoundException("Khong ton tai employee voi id=" + id)
        );
    }

    public MessageResponse addEmployeeToDepartment(AddEmployeeDepartment req) {

        Employee employee = employeeRepository.findById(req.getEmployeeId()).orElse(null);
        if (employee != null) {
            employee.setDepartmentId(req.getDepartmentId());
            employeeRepository.save(employee);
            return MessageResponse.builder().message("SUCCESS").build();
        }
        return MessageResponse.builder().message("Employee is not exist").build();
    }
}
