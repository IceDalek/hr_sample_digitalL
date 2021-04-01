package ru.atc.hrsample.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ru.atc.hrsample.dto.DepartmentDTO;
import ru.atc.hrsample.entity.DepartmentChiefEntity;
import ru.atc.hrsample.entity.DepartmentEntity;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface DepartmentsMapper {
    @Select("select department_name, first_name, last_name, employee_id, city, street_address from employees inner join\n" +
            "           departments d on employees.employee_id = d.manager_id\n" +
            "           inner join locations l on l.location_id = d.location_id where  d.department_id = #{id};")
    Optional<DepartmentChiefEntity> getChiefById(Integer id);

    @Select("select department_name, first_name, last_name, employee_id, city, street_address\n" +
            "from departments\n" +
            "         inner join employees e on departments.manager_id = e.employee_id\n" +
            "         inner join locations l on l.location_id = departments.location_id where last_name = #{name};")
    List<DepartmentChiefEntity> getDepartmentsByManagerLastName(String name);

    @Select("select department_name, first_name, last_name, employee_id, city, street_address\n" +
            "from departments\n" +
            "         inner join employees e on departments.manager_id = e.employee_id\n" +
            "         inner join locations l on l.location_id = departments.location_id where department_name = #{name};")
    List<DepartmentChiefEntity> getDepartmentsByDepartmentName(String name);

    @Select(
            "select department_name, first_name, last_name, employee_id, city, street_address\n" +
                    "from departments\n" +
                    "         inner join employees e on departments.manager_id = e.employee_id\n" +
                    "         inner join locations l on l.location_id = departments.location_id;")
    List<DepartmentChiefEntity> getAllDepartments();

    @Insert("insert into departments(department_id, department_name, manager_id, location_id) VALUES" +
            " (#{departmentId}, #{departmentName}, #{managerId}, #{locationId})")
    void addDepartment(DepartmentEntity departmentEntity);

    @Update("UPDATE departments\n" +
            "SET department_name = #{departmentEntity.departmentName}," +
            " manager_id = #{departmentEntity.managerId}," +
            " location_id = #{departmentEntity.locationId}\n" +
            "    WHERE department_id = #{id};")
    void updateDepartmentById(Integer id, DepartmentEntity departmentEntity);

    @Select("select * from departments where department_id = #{id}")
    Optional<DepartmentEntity> getDepartmentById(Integer id);
}
