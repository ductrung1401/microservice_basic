package com.trungtd.departmentservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddEmployeeDepartment {
    private Long departmentId;
    private Long employeeId;

}