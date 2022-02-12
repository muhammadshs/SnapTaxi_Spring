package com.dwteam.driver;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    Driver toEntity(DriverDTO driverDTO);
    DriverDTO toDTO(Driver driver);
}
