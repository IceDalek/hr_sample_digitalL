package ru.atc.hrsample.dto;

import lombok.Data;

import java.sql.Date;
@Data
public class EmployeeAllInfoDTO {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private Integer salary;
    private Integer departmentId;
    private String departmentName;
    private Date startDate;
    private Date endDate;
}
