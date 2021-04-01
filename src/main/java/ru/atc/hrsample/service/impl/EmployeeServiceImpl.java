package ru.atc.hrsample.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.atc.hrsample.dao.EmployeeMapper;
import ru.atc.hrsample.dao.JobsMapper;
import ru.atc.hrsample.dto.DepartmentDTO;
import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.DepartmentEntity;
import ru.atc.hrsample.entity.EmployeeAllInfoEntity;
import ru.atc.hrsample.entity.EmployeeEntity;
import ru.atc.hrsample.entity.JobEntity;
import ru.atc.hrsample.service.api.EmployeeService;
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
        employeeMapper.insertEmployee(employeeEntity);
        return employeeDTO;
    }
    @Override
    public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO, JobDTO jobDTO){
        JobEntity jobEntity = modelMapper.map(jobDTO, JobEntity.class);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        jobsMapper.addNewJob(jobEntity);
        employeeEntity.setJobId(jobEntity.getJobId());
        employeeMapper.insertEmployee(employeeEntity);
        return employeeDTO;
    }
}
