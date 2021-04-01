package ru.atc.hrsample.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.atc.hrsample.dao.DepartmentsMapper;
import ru.atc.hrsample.dto.DepartmentChiefDTO;
import ru.atc.hrsample.dto.DepartmentDTO;
import ru.atc.hrsample.entity.DepartmentChiefEntity;
import ru.atc.hrsample.entity.DepartmentEntity;
import ru.atc.hrsample.service.api.DepartmentsService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentsServiceImpl implements DepartmentsService {

    private final DepartmentsMapper departmentsMapper;

    private final ModelMapper modelMapper;

    @Override
    public DepartmentChiefDTO getDepartmentChiefById(Integer id) {
        DepartmentChiefEntity departmentChiefEntity = departmentsMapper.getChiefById(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Не найдена сущность департамента по идентификатору=%s", id)
                )
        );
        log.debug("Получена сущность департамента с id={}", id);
        return modelMapper.map(departmentChiefEntity, DepartmentChiefDTO.class);
    }

    @Override
    public List<DepartmentChiefDTO> getDepartmentsByDepartmentName(String name) {
        List<DepartmentChiefEntity> entities = departmentsMapper.getDepartmentsByDepartmentName(name);
        log.debug("Получены все сущности департаментов c именем " + " name");
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }

    @Override
    public List<DepartmentChiefDTO> getDepartmentsByManagerLastName(String name) {
        List<DepartmentChiefEntity> entities = departmentsMapper.getDepartmentsByManagerLastName(name);
        log.debug("Получены все сущности департаментов c фамилией менеджара " + " name");
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }

    @Override
    public List<DepartmentChiefDTO> getAllDepartments() {
        List<DepartmentChiefEntity> entities = departmentsMapper.getAllDepartments();
        log.debug("Получены все сущности департаментов");
        return modelMapper.map(entities, TypeToken.of(List.class).getType());
    }

    @Override
    @Transactional
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentsMapper.addDepartment(departmentEntity);
        log.info("Создана сущность департамента с id={}", departmentEntity.getLocationId());
        Integer id = departmentDTO.getDepartmentId();
        DepartmentEntity ret = departmentsMapper.getDepartmentById(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Не найдена сущность департамента по идентификатору=%s", id)
                )
        );
        return modelMapper.map(ret, DepartmentDTO.class);
    }

    @Override
    @Transactional
    public DepartmentDTO updateDepartmentById(Integer id, DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentsMapper.updateDepartmentById(id, departmentEntity);
        log.info("Обновлена сущность департамента с id=%d", id);
        DepartmentEntity ret = departmentsMapper.getDepartmentById(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Не найдена сущность департамента по идентификатору=%s", id)
                )
        );
        return modelMapper.map(ret, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO getDepartmentById(Integer id) {
        DepartmentEntity departmentEntity = departmentsMapper.getDepartmentById(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Не найдена сущность департамента по идентификатору=%s", id)
                )
        );
        log.debug("Получена сущность департамента с id={}", id);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }
}
