package ru.atc.hrsample.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import ru.atc.hrsample.dao.EmployeeMapper;
import ru.atc.hrsample.dao.JobsMapper;
import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.DepartmentChiefEntity;
import ru.atc.hrsample.entity.EmployeeAllInfoEntity;
import ru.atc.hrsample.entity.EmployeeEntity;
import ru.atc.hrsample.entity.JobEntity;
import ru.atc.hrsample.service.api.EmployeeService;

import java.util.List;
/**
 * Реализация сервиса по взаимодействию с работниками
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final JobsMapper jobsMapper;
    private final ModelMapper modelMapper;
    @Override
    public EmployeeAllInfoDTO getEmployeeInfoById(Integer id) {
        EmployeeAllInfoEntity infoEntity = employeeMapper.getEmployeeInfoById(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Не найдена сущность департамента по идентификатору=%s", id)
                )
        );
        log.debug("Получена сущность сотрудника с id={}", id);
        return modelMapper.map(infoEntity, EmployeeAllInfoDTO.class);
    }

    @Override
    public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeMapper.addEmployee(employeeEntity);
        return employeeDTO;
    }
    @Override
    public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO, JobDTO jobDTO){
        JobEntity jobEntity = modelMapper.map(jobDTO, JobEntity.class);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        jobsMapper.addNewJob(jobEntity);
        employeeEntity.setJobId(jobEntity.getJobId());
        employeeMapper.addEmployee(employeeEntity);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
       EmployeeEntity employeeEntity = employeeMapper.getEmployeeById(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Не найдена сущность работника по идентификатору=%s", id)
                )
        );
       return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Integer id) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        updateJobHistoryOfEmployee(employeeDTO);
        employeeMapper.updateEmployeeById(employeeEntity.getEmployeeId(), employeeEntity);
        return employeeDTO;
    }

    @Override
    public void updateJobHistoryOfEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        jobsMapper.updateJobHistoryOfEmployee(employeeEntity);
    }

    @Override
    public List<EmployeeAllInfoDTO> getAllEmployeeByQuery(String column, String q) {
        List<EmployeeAllInfoEntity> entities = employeeMapper.getAllEmployeeByQuery(column, q);
        log.debug(entities.toString());
        log.debug("Получены все сущности работников по  " + column + " = " + q);
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }
}
