package com.dwteam.trip;

import com.dwteam.driver.DriverMapper;
import com.dwteam.passenger.PassengerMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {PassengerMapper.class, DriverMapper.class})
public interface TripMapper {
    Trip toEntity(TripDTO tripDTO);
    TripDTO toDTO(Trip trip);
}
