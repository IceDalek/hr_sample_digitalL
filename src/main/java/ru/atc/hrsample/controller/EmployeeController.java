package ru.atc.hrsample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.misc.EmployeeAndJobContainer;
import ru.atc.hrsample.service.api.EmployeeService;
import ru.atc.hrsample.service.api.JobService;

import java.util.List;

/**
 * Апи для взаимодействия с работниками
 */
@Slf4j
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Tag(name = "employee", description = "Апи для взаимодействия с работниками")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final JobService jobService;

    @Operation(summary = "Получить расширенную информацию о работнике по id")
    @GetMapping("{employee_id}")
    public EmployeeAllInfoDTO getEmployeeById(@PathVariable Integer employee_id) {
        return employeeService.getEmployeeInfoById(employee_id);
    }

    @Operation(summary = "Добавить новую работу")
    @PostMapping("/job")
    public JobDTO addNewJob(@RequestBody JobDTO jobDTO) {
        return jobService.addNewJob(jobDTO);
    }

    @Operation(summary = "Добавить нового работника")
    @PostMapping()
    public EmployeeDTO addNewEmployee(@RequestBody EmployeeAndJobContainer container) {
        EmployeeDTO employeeDTO = container.employeeDTO;
        JobDTO jobDTO = container.jobDTO;
        if (employeeDTO.getJobId() == null && jobDTO != null) {
            return employeeService.addNewEmployee(employeeDTO, jobDTO);
        }
        return employeeService.addNewEmployee(employeeDTO);
    }

    @Operation(summary = "Обновить данные о работнике")
    @PostMapping("{employee_id}")
    public EmployeeDTO updateEmployee(@PathVariable Integer employee_id,
                                      @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeById(employeeDTO, employee_id);
    }

    @Operation(summary = "получить список расширенной информации о" +
            " работниках на по названию колонки и запросу")
    @GetMapping()
    public List<EmployeeAllInfoDTO> getAllEmployeeByQuery(@RequestParam String column,
                                                          @RequestParam String q) {
        return employeeService.getAllEmployeeByQuery(column, q);
    }
}
