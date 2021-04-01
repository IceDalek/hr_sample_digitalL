package ru.atc.hrsample.entity;

import lombok.Data;

@Data
public class DepartmentEntity {
    private Integer departmentId;
    private String departmentName;
    private Integer managerId;
    private Integer locationId;
}
