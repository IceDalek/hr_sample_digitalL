package ru.atc.hrsample.dto;

import lombok.Data;

@Data
public class DepartmentChiefDTO {
    private String departmentName;
    private String firstName;
    private String lastName;
    private Integer employeeId;
    private String city;
    private String streetAddress;
}
