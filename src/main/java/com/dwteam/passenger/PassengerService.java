package com.dwteam.passenger;

import org.springframework.beans.factory.annotation.Autowired;

public class PassengerService implements IPassengerService{
    PassengerRepository passengerRepository;
    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Long login(String userName, String passWord) {
        Passenger passenger=passengerRepository.findByUserNameAndPassWord(userName,passWord).get();
        return passenger.getId();
    }
}
