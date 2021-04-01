package ru.atc.hrsample.dto;

import lombok.Data;

@Data
public class JobDTO {
    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;
}
