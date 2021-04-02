package ru.atc.hrsample.service.api;

import org.springframework.transaction.annotation.Transactional;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.JobEntity;

/**
 * Сервис для взаимодействия с работами
 */
public interface JobService {
    /**
     * Добавление новой работы
     *
     * @param jobDTO
     * @return
     */
    JobDTO addNewJob(JobDTO jobDTO);

    /**
     * Получение работы по id
     *
     * @param id
     * @return
     */
    JobDTO getJobById(Integer id);

}
