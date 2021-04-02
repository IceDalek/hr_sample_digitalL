package ru.atc.hrsample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.EmployeeEntity;
import ru.atc.hrsample.entity.JobEntity;

import java.util.Optional;

@Mapper
@Repository
public interface JobsMapper {
    @Insert("insert into jobs(job_id, job_title, min_salary, max_salary)\n" +
            "VALUES ( #{jobId},#{jobTitle},#{minSalary},#{maxSalary}\n" +
            "       );")
    void addNewJob(JobEntity jobEntity);

    @Select("select * from jobs where job_id = #{id}")
    Optional<JobEntity> getJobById(Integer id);

    @Insert("insert into job_history(employee_id, start_date, end_date, job_id, department_id) VALUES (\n" +
            "#{employeeId}, #{hireDate}, current_date, #{jobId}, #{departmentId}\n" +
            ");")
    void updateJobHistoryOfEmployee(EmployeeEntity employeeEntity);
}
