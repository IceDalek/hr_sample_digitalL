package ru.atc.hrsample.service.api;

import ru.atc.hrsample.dto.EmployeeAllInfoDTO;
import ru.atc.hrsample.dto.EmployeeDTO;
import ru.atc.hrsample.dto.JobDTO;
import ru.atc.hrsample.entity.EmployeeAllInfoEntity;
import ru.atc.hrsample.entity.EmployeeEntity;

import java.util.List;

/**
 * Сервис для взаимодействия с работниками
 */
public interface EmployeeService {
    /**
     * получение расширенной информации о работнике по id
     *
     * @param id
     * @return
     */
    EmployeeAllInfoDTO getEmployeeInfoById(Integer id);

    /**
     * добавление нового работника
     *
     * @param employeeDTO работник
     * @return
     */

    EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO);

    /**
     * добавление нового работника и новой работы с привязкой к ней
     *
     * @param employeeDTO работник
     * @param jobDTO      новая работа
     * @return
     */

    EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO, JobDTO jobDTO);

    /**
     * получить работника по его id
     *
     * @param id
     * @return
     */
    EmployeeDTO getEmployeeById(Integer id);

    /**
     * обновить работника
     *
     * @param employeeDTO обновленные данные о работнике
     * @param id          id работника которого требуется обновить
     * @return
     */
    EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Integer id);

    /**
     * обновить историю работы работника
     *
     * @param employeeDTO работник
     */
    void updateJobHistoryOfEmployee(EmployeeDTO employeeDTO);

    /**
     * получить всех работников по заданным параметрам
     *
     * @param column название таблицы КАК В БАЗЕ например :(last_name)
     * @param q      поисковой запрос например: ("Peshnin")
     * @return отфильтрованный список работников
     */
    List<EmployeeAllInfoDTO> getAllEmployeeByQuery(String column, String q);
}
