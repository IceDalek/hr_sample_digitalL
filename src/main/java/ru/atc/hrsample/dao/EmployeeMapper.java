package ru.atc.hrsample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ru.atc.hrsample.entity.EmployeeAllInfoEntity;
import ru.atc.hrsample.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;
/**
 * Репозиторий работников
 */
@Repository
@Mapper
public interface EmployeeMapper {
    /**
     * Получить расширенную информацию о сотруднике по его id
     *
     * @param id
     * @return расширенную информацию о сотруднике
     */
    @Select("select distinct on (employees.employee_id) employees.employee_id, first_name, last_name,\n" +
            "       email, phone_number, hire_date,\n" +
            "       employees.job_id, salary, d.department_id,\n" +
            "       department_name,\n      start_date,\n" +
            "                                                end_date" +

            "\n" +
            "from employees\n" +
            "         inner join departments d on d.department_id = employees.department_id\n" +
            "         inner join locations l on l.location_id = d.location_id\n" +
            "         left join job_history jh on employees.employee_id = jh.employee_id\n" +
            "where employees.employee_id = #{id};")
    Optional<EmployeeAllInfoEntity> getEmployeeInfoById(Integer id);

    /**
     * Добавить нового работника
     *
     * @param employeeEntity
     */
    @Insert("insert into employees(employee_id, first_name, last_name,\n" +
            "                      email, phone_number, hire_date,\n" +
            "                      job_id, salary, manager_id, department_id)\n" +
            "VALUES (#{employeeId}, #{firstName}, #{lastName}, #{email}, #{phoneNumber}," +
            " #{hireDate}, #{jobId}, #{salary}, #{managerId}, #{departmentId});")
    void addEmployee(EmployeeEntity employeeEntity);

    /**
     * Обновить информацию о работнике
     *
     * @param id
     * @param employeeEntity
     */
    @Update("update employees set first_name = #{employeeEntity.firstName}," +
            " last_name = #{employeeEntity.lastName}," +
            " email = #{employeeEntity.email},\n" +
            " phone_number = #{employeeEntity.phoneNumber}," +
            " hire_date= #{employeeEntity.hireDate}," +
            " job_id = #{employeeEntity.jobId}," +
            " salary = #{employeeEntity.salary},\n" +
            " manager_id = #{employeeEntity.managerId}," +
            " department_id = #{employeeEntity.departmentId}" +
            " where employee_id = #{id};")
    void updateEmployeeById(Integer id, EmployeeEntity employeeEntity);

    /**
     * Получить работника по id
     *
     * @param id
     * @return контейнер, содержащий сущность работника
     */
    @Select("select * from employees where employee_id = #{id};")
    Optional<EmployeeEntity> getEmployeeById(Integer id);

    /**
     * получает информацию о работнике по заданному полю
     *
     * @param column поле по которому осуществляется поиск
     * @param q      поисковой запрос
     * @return
     */
    @Select("select distinct on (employees.employee_id) employees.employee_id, first_name, last_name,\n" +
            "                                           email, phone_number, hire_date,\n" +
            "                                           employees.job_id, salary, d.department_id,\n" +
            "                                           department_name,\n" +
            "                                           start_date,\n" +
            "                                           end_date\n" +
            "from employees\n" +
            "         inner join departments d on d.department_id = employees.department_id\n" +
            "         inner join locations l on l.location_id = d.location_id\n" +
            "         left join job_history jh on employees.employee_id = jh.employee_id\n" +
            "where ${column} = #{q};\n" +
            ";\n")
    List<EmployeeAllInfoEntity> getAllEmployeeByQuery(String column, String q);

}
