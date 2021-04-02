package ru.atc.hrsample.service.api;

import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.EmployeeAllInfoEntity;
import ru.atc.hrsample.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeAllInfoDTO getEmployeeInfoById(Integer id);

    EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO, JobDTO jobDTO);

    EmployeeDTO getEmployeeById(Integer id);

    EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Integer id);

    void updateJobHistoryOfEmployee(EmployeeDTO employeeDTO);

    List<EmployeeAllInfoDTO> getAllEmployeeByQuery(String column, String q);
}
