package ru.atc.hrsample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
/**
 * Модель департамента
 */
@Data
public class DepartmentDTO {
    @Schema(title = "id департамента")
    private Integer departmentId;
    @Schema(title = "название департамента")
    private String departmentName;
    @Schema(title = "id менеджера")
    private Integer managerId;
    @Schema(title = "id места")
    private Integer locationId;
}
