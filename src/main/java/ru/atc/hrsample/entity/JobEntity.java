package ru.atc.hrsample.entity;

import lombok.Data;

@Data
public class JobEntity {
    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;
}
