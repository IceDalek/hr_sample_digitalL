package ru.atc.hrsample.entity;

import lombok.Data;

import java.sql.Date;

/**
 * Представление работника в базе данных
 */
@Data
public class EmployeeEntity {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private Integer salary;
    private Integer managerId;
    private Integer departmentId;
}
