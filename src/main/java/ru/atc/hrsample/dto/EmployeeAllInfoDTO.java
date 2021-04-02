package ru.atc.hrsample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Date;
/**
 * Модель расширенной информации о работнике
 */
@Data
public class EmployeeAllInfoDTO {
    @Schema(title = "id")
    private Integer employeeId;
    @Schema(title = "Имя")
    private String firstName;
    @Schema(title = "Фамилия")
    private String lastName;
    @Schema(title = "Эл почта")
    private String email;
    @Schema(title = "Номер телефона")
    private String phoneNumber;
    @Schema(title = "Дата найма")
    private Date hireDate;
    @Schema(title = "Его работа")
    private String jobId;
    @Schema(title = "Зп")
    private Integer salary;
    @Schema(title = "id директора")
    private Integer managerId;
    @Schema(title = "id департамента")
    private Integer departmentId;
    @Schema(title = "название департамента")
    private String departmentName;
    @Schema(title = "дата начала работы")
    private Date startDate;
    @Schema(title = "дата окончания работы")
    private Date endDate;
}
