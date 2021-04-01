package ru.atc.hrsample.service.api;

import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.EmployeeEntity;

public interface EmployeeService {
    EmployeeAllInfoDTO getEmployeeInfoById(Integer id);
    EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO, JobDTO jobDTO);
}
