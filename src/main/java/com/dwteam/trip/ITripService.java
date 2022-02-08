package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;

public interface ITripService {
    Trip creatTrip(Passenger passenger, Driver driver,Double sourceLat,Double sourceLong,Double targetLat,Double targetLong);
    Boolean deleteBy(Long passengerId,Integer state);
    void changeDriver(Long id);
    void changeLocations(Long id,Double targetLong,Double targetLat,Double sourceLong,Double sourceLat);
    void changePrice(Long id);
    void changeState(Long id);
    Trip selectTrip(Long id);
    Trip selectTripWithDriver(Driver driver,Integer state);
    void saveTrip(Trip trip);
}
