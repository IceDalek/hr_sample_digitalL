package ru.atc.hrsample.service.api;

import org.apache.ibatis.annotations.Update;
import ru.atc.hrsample.dto.DepartmentChiefDTO;
import ru.atc.hrsample.dto.DepartmentDTO;
import ru.atc.hrsample.entity.DepartmentChiefEntity;
import ru.atc.hrsample.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentsService {
    DepartmentChiefDTO getDepartmentChiefById(Integer id);

    List<DepartmentChiefDTO> getDepartmentsByDepartmentName(String name);

    List<DepartmentChiefDTO> getDepartmentsByManagerLastName(String name);

    List<DepartmentChiefDTO> getAllDepartments();

    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO updateDepartmentById(Integer id, DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentById(Integer id);
}
