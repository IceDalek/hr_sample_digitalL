package ru.atc.hrsample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * модель главы департамента
 */
@Data
public class DepartmentChiefDTO {
    @Schema(title = "Имя департамента")
    private String departmentName;
    @Schema(title = "Имя")
    private String firstName;
    @Schema(title = "Фамилия")
    private String lastName;
    @Schema(title = "id")
    private Integer employeeId;
    @Schema(title = "Город где находится его департамент")
    private String city;
    @Schema(title = "Адрес департамента")
    private String streetAddress;
}
