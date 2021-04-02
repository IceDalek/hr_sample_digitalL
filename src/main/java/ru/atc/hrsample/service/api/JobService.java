package ru.atc.hrsample.service.api;

import org.springframework.transaction.annotation.Transactional;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.JobEntity;

public interface JobService {

    JobDTO addNewJob(JobDTO jobDTO);
    JobDTO getJobById(Integer id);

}
