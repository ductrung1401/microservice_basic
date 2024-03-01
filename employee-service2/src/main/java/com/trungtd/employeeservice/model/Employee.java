package com.trungtd.employeeservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "position")
    private String position;
    @Column(name = "department_Id")
    private Long departmentId;
}
