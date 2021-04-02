package ru.atc.hrsample.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.atc.hrsample.dao.EmployeeMapper;
import ru.atc.hrsample.dao.JobsMapper;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.DepartmentEntity;
import ru.atc.hrsample.entity.EmployeeEntity;
import ru.atc.hrsample.entity.JobEntity;
import ru.atc.hrsample.service.api.JobService;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImpl implements JobService {
    private final JobsMapper jobsMapper;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public JobDTO addNewJob(JobDTO jobDTO) {
        JobEntity jobEntity = modelMapper.map(jobDTO, JobEntity.class);
        jobsMapper.addNewJob(jobEntity);
        log.info("Создана сущность работы с id={}", jobEntity.getJobId());
        return jobDTO;
    }

    @Override
    public JobDTO getJobById(Integer id) {
        JobEntity jobEntity = jobsMapper.getJobById(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Не найдена сущность работы по идентификатору=%s", id)
                )
        );
        return modelMapper.map(jobEntity, JobDTO.class);
    }

}
