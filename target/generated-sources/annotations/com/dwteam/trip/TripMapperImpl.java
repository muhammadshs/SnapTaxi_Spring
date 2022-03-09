package com.dwteam.trip;

import com.dwteam.passenger.PassengerMapper;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-04T20:50:18+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class TripMapperImpl implements TripMapper {

    @Autowired
    private PassengerMapper passengerMapper;

    @Override
    public Trip toEntity(TripDTO tripDTO) {
        if ( tripDTO == null ) {
            return null;
        }

        Trip trip = new Trip();

        trip.setPrice( tripDTO.getPrice() );
        trip.setPassenger( passengerMapper.toEntity( tripDTO.getPassenger() ) );
        trip.setState( tripDTO.getState() );
        trip.setCreatDate( tripDTO.getCreatDate() );
        trip.setSourceLat( tripDTO.getSourceLat() );
        trip.setSourceLong( tripDTO.getSourceLong() );
        trip.setTargetLat( tripDTO.getTargetLat() );
        trip.setTargetLong( tripDTO.getTargetLong() );

        return trip;
    }

    @Override
    public TripDTO toDTO(Trip trip) {
        if ( trip == null ) {
            return null;
        }

        TripDTO tripDTO = new TripDTO();

        tripDTO.setPrice( trip.getPrice() );
        tripDTO.setPassenger( passengerMapper.toDTO( trip.getPassenger() ) );
        tripDTO.setState( trip.getState() );
        tripDTO.setCreatDate( trip.getCreatDate() );
        tripDTO.setSourceLat( trip.getSourceLat() );
        tripDTO.setSourceLong( trip.getSourceLong() );
        tripDTO.setTargetLat( trip.getTargetLat() );
        tripDTO.setTargetLong( trip.getTargetLong() );

        return tripDTO;
    }
}
