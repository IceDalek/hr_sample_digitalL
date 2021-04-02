package ru.atc.hrsample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.atc.hrsample.dto.DepartmentChiefDTO;
import ru.atc.hrsample.dto.DepartmentDTO;
import ru.atc.hrsample.service.api.DepartmentsService;

import java.util.List;

/**
 * Апи для взаимодействия с департаментами
 */
@Slf4j
@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@Tag(name = "departments", description = "Апи для взаимодействия с департаментами")
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @GetMapping("/{departmentId}")
    @Operation(summary = "Получение департамента по идентификатору")
    public DepartmentChiefDTO getDepartmentById(@PathVariable Integer departmentId) {
        return departmentsService.getDepartmentChiefById(departmentId);
    }

    @Operation(summary = "получение всех департаментов фильтр задается в виде параметра," +
            " если параметры не указаны, то возвращается список всех департаментов" +
            "если в параметре есть строка last, то возвращается список всех департаментов" +
            " по фамилии менеджера(параметр q), если в параметре есть строка dep," +
            " то возвращается список всех департаментов по его имени(параметр q)")
    @GetMapping()
    public List<DepartmentChiefDTO> getAllDepartments(@RequestParam(required = false) String search,
                                                      @RequestParam(required = false) String q) {
        if (search == null || q == null) {
            return departmentsService.getAllDepartments();
        }
        if (search.contains("last")) {
            return departmentsService.getDepartmentsByManagerLastName(q);
        }
        if (search.contains("dep")) {
            return departmentsService.getDepartmentsByDepartmentName(q);
        } else return null;

    }

    @Operation(summary = "добавить новый департамент")
    @PostMapping()
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentsService.addDepartment(departmentDTO);
    }

    @Operation(summary = "обновить существующий департамент")
    @PostMapping("/{departmentId}")
    public DepartmentDTO updateDepartment(@PathVariable Integer departmentId,
                                          @RequestBody DepartmentDTO departmentDTO) {
        return departmentsService.updateDepartmentById(departmentId, departmentDTO);
    }
}
