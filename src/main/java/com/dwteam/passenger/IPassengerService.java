package com.dwteam.passenger;

import com.dwteam.driver.Driver;
import com.dwteam.trip.Trip;

public interface IPassengerService {
    Long login(String userName,String passWord);
    Passenger savePassenger(Passenger passenger);
    void changeState(Long id ,Integer state);
}
