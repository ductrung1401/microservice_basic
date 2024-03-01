package com.trungtd.departmentservice.service;

import com.trungtd.departmentservice.model.AddEmployeeDepartment;
import com.trungtd.departmentservice.model.Department;
import com.trungtd.departmentservice.response.MessageResponse;
import com.trungtd.departmentservice.service.implement.DepartmentServiceImpl;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);

    List<Department> getAllDepartment();

    Department getDepartmentById(Long id);

//    MessageResponse addEmployeeToDepartment(AddEmployeeDepartment req);
    //0021000429042
}
