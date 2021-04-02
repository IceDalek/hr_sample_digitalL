package ru.atc.hrsample.entity;

import lombok.Data;

/**
 * Представление места в базе данных
 */
@Data
public class LocationsEntity {
    private Integer locationId;
    private String streetAddress;
    private String city;
}
