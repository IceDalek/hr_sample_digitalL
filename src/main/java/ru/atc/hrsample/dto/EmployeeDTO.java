package ru.atc.hrsample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Date;
/**
 * Модель работника
 */
@Data
public class EmployeeDTO {
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
    @Schema(title = "id Директора")
    private Integer managerId;
    @Schema(title = "id Департамента")
    private Integer departmentId;
}
