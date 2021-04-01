package ru.atc.hrsample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.JobEntity;
@Mapper
@Repository
public interface JobsMapper {
    @Insert("insert into jobs(job_id, job_title, min_salary, max_salary)\n" +
            "VALUES ( #{jobId},#{jobTitle},#{minSalary},#{maxSalary}\n" +
            "       );")
    void addNewJob(JobEntity jobEntity);
}
