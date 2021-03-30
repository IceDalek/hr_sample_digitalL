package ru.atc.hrsample.service.api;

import ru.atc.hrsample.dto.LocationsDto;

import java.util.List;

/**
 * Сервис для работы с локациями
 */
public interface LocationsService {

    /**
     * Получает сущность локации по ид
     *
     * @param id идентификатор
     * @return сохраненная сущность с ид.
     */
    LocationsDto getLocationById(Integer id);

    LocationsDto insertLocation(LocationsDto dto);

    List<LocationsDto> getAll();
}
