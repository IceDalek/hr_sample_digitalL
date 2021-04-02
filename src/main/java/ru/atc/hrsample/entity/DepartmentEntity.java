package ru.atc.hrsample.entity;

import lombok.Data;

/**
 * Представление департамента в базе данных
 */
@Data
public class DepartmentEntity {
    private Integer departmentId;
    private String departmentName;
    private Integer managerId;
    private Integer locationId;
}
