package com.dwteam.passenger;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-11T12:01:36+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PassengerMapperImpl implements PassengerMapper {

    @Override
    public Passenger toEntity(PassengerDTO passengerDTO) {
        if ( passengerDTO == null ) {
            return null;
        }

        Passenger passenger = new Passenger();

        passenger.setUserName( passengerDTO.getUserName() );
        passenger.setPassWord( passengerDTO.getPassWord() );
        passenger.setPhoneNumber( passengerDTO.getPhoneNumber() );
        passenger.setBalance( passengerDTO.getBalance() );
        passenger.setId( passengerDTO.getId() );

        return passenger;
    }

    @Override
    public PassengerDTO toDTO(Passenger passenger) {
        if ( passenger == null ) {
            return null;
        }

        PassengerDTO passengerDTO = new PassengerDTO();

        passengerDTO.setId( passenger.getId() );
        passengerDTO.setUserName( passenger.getUserName() );
        passengerDTO.setPassWord( passenger.getPassWord() );
        passengerDTO.setPhoneNumber( passenger.getPhoneNumber() );
        passengerDTO.setBalance( passenger.getBalance() );

        return passengerDTO;
    }
}
