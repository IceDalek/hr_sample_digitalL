package ru.atc.hrsample.entity;

import lombok.Data;

@Data
public class LocationsEntity {
    private Integer locationId;
    private String streetAddress;
    private String city;
}
