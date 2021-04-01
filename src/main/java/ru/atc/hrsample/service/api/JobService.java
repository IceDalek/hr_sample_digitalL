package ru.atc.hrsample.service.api;

import org.springframework.transaction.annotation.Transactional;
import ru.atc.hrsample.dto.JobDTO;

public interface JobService {
    @Transactional
    JobDTO addNewJob(JobDTO jobDTO);
}
