package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;

public interface ITripService {
    Trip creatTrip(Trip trip);
    Boolean deleteBy(Long passengerId,Integer state);

    void changePrice(Long id);
    void changeState(Long id,Integer state);
    Trip selectTrip(Long id);
    Trip selectTripWithDriver(Driver driver,Integer state);
    void saveTrip(Trip trip);
}
