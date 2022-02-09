package com.dwteam.passenger;

import com.dwteam.trip.Trip;

public interface IPassengerService {
    Long login(String userName,String passWord);

    void changeState(Long id ,Integer state);
}
