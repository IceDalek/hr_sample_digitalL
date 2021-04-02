package ru.atc.hrsample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
/**
 * Модель работы
 */
@Data
public class JobDTO {
    @Schema(title = "id работы")
    private String jobId;
    @Schema(title = "Название работы")
    private String jobTitle;
    @Schema(title = "мин зп")
    private Integer minSalary;
    @Schema(title = "макс зп")
    private Integer maxSalary;
}
