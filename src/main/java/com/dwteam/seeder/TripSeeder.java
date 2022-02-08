package com.dwteam.seeder;

import com.dwteam.driver.Driver;
import com.dwteam.driver.DriverRepository;
import com.dwteam.passenger.Passenger;
import com.dwteam.passenger.PassengerRepository;
import com.dwteam.trip.Trip;
import com.dwteam.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


public class TripSeeder implements ApplicationRunner {
    TripRepository tripRepository;
    DriverRepository driverRepository;
    PassengerRepository passengerRepository;
    @Autowired
    public TripSeeder(TripRepository tripRepository, DriverRepository driverRepository, PassengerRepository passengerRepository) {
        this.tripRepository = tripRepository;
        this.driverRepository = driverRepository;
        this.passengerRepository = passengerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i=1;i<500;i++){
            Trip trip=new Trip();
            trip.setDate(new Date());
            Optional<Driver> op=driverRepository.findById(Long.valueOf(i));
            trip.setDriver(op.get());
            Optional<Passenger> op2=passengerRepository.findById(Long.valueOf(i));
            trip.setPassenger(op2.get());
            trip.setPrice(7364.475+i);
            trip.setSourceLat(23.96865+i);
            trip.setSourceLong(34.957+i);
            trip.setTargetLat(2.667+i);
            trip.setTargetLong(34.968+i);
            tripRepository.save(trip);
        }
    }
}
