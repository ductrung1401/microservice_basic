package com.trungtd.departmentservice.service.implement;

import com.trungtd.departmentservice.custom.exception.ExistsException;
import com.trungtd.departmentservice.model.AddEmployeeDepartment;
import com.trungtd.departmentservice.model.Department;
import com.trungtd.departmentservice.repository.DepartmentRepository;
import com.trungtd.departmentservice.response.MessageResponse;
import com.trungtd.departmentservice.service.DepartmentService;
import jakarta.ws.rs.NotFoundException;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

//    private RestTemplate restTemplate;

    @Override
    public Department addDepartment(Department department) {
//        Optional<Department> departmentOptional = Optional.ofNullable(department);
//
//        departmentOptional.ifPresent(value -> departmentRepository.save(value));
//        return departmentOptional.get();
        Optional.ofNullable(department)
                .filter(dep -> !departmentRepository.existsById(dep.getId()))
                .orElseThrow(
                        () -> new ExistsException("Department cannot be null or already exists")
                );
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        if (!departments.isEmpty())
            return departments;
        else
            throw new NotFoundException("Khong ton tai phong ban nao trong he thong");
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(
                () -> new com.trungtd.departmentservice.custom.exception.NotFoundException("Khong ton tai phong ban voi id=" + id)
        );
    }

//    @Override
//    public MessageResponse addEmployeeToDepartment(AddEmployeeDepartment req) {
//        Department department = this.getDepartmentById(req.getDepartmentId());
//        MessageResponse response =
//                restTemplate.postForObject("http://localhost:8082/api/v1/employee/add-to-department", req, MessageResponse.class);
//        return response;
//    }
}
