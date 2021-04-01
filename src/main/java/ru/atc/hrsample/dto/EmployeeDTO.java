package ru.atc.hrsample.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeDTO {

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
