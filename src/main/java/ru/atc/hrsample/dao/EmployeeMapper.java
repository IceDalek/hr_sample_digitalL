package ru.atc.hrsample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.entity.EmployeeAllInfoEntity;
import ru.atc.hrsample.entity.EmployeeEntity;

import java.util.Optional;

@Repository
@Mapper
public interface EmployeeMapper {
@Select("select jh.employee_id, first_name, last_name,\n" +
        "       email, phone_number, hire_date,\n" +
        "       employees.job_id, salary, d.department_id,\n" +
        "       department_name,\n" +
        "    start_date,end_date\n" +
        "\n" +
        "from employees\n" +
        "         inner join departments d on d.department_id = employees.department_id\n" +
        "         inner join locations l on l.location_id = d.location_id\n" +
        "         inner join job_history jh on employees.employee_id = jh.employee_id\n" +
        "where employees.employee_id = #{id};")
    Optional<EmployeeAllInfoEntity> getEmployeeInfoById(Integer id);
@Insert("insert into employees(employee_id, first_name, last_name,\n" +
        "                      email, phone_number, hire_date,\n" +
        "                      job_id, salary, manager_id, department_id)\n" +
        "VALUES (#{employeeId}, #{firstName}, #{lastName}, #{email}, #{phoneNumber}," +
        " #{hireDate}, #{jobId}, #{salary}, #{managerId}, #{departmentId});")
    void insertEmployee(EmployeeEntity employeeEntity);

}
