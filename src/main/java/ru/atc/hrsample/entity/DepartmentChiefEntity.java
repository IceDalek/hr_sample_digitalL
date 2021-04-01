package ru.atc.hrsample.entity;

import lombok.Data;

@Data
public class DepartmentChiefEntity {
    private String departmentName;
    private String firstName;
    private String lastName;
    private Integer employeeId;
    private String streetAddress;
    private String city;

}
