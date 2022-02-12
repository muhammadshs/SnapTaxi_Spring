package com.dwteam.passenger;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    Passenger toEntity(PassengerDTO passengerDTO);
    PassengerDTO toDTO(Passenger passenger);
}
