package ru.atc.hrsample.dto;

import lombok.Data;

@Data
public class DepartmentDTO {
    private Integer departmentId;
    private String departmentName;
    private Integer managerId;
    private Integer locationId;
}
