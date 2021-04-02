package ru.atc.hrsample.entity;

import lombok.Data;

/**
 * Представление работы в базе данных
 */
@Data
public class JobEntity {
    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;
}
