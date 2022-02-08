package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class TripService implements ITripService {
    TripRepository tripRepository;

    @Override
    public Trip creatTrip(Passenger passenger, Driver driver, Double sourceLat, Double sourceLong, Double targetLat, Double targetLong) {
        Trip trip=new Trip();
        trip.setTargetLong(targetLong);
        trip.setPassenger(passenger);
        trip.setTargetLat(targetLat);
        trip.setPrice((double) getRandomNumber(10000,200000));
        trip.setDriver(driver);
        trip.setDate(new Date());
        trip.setSourceLong(sourceLong);
        trip.setSourceLat(sourceLat);
        trip.setState(0);
        return tripRepository.save(trip);
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    @Override
    public Boolean deleteBy(Long passengerId, Integer state) {

        return tripRepository.deleteByPassenger_IdAndState(passengerId,state);
    }

    @Override
    public void changeDriver(Long id) {
        Trip trip=tripRepository.findTripById(id).get();
        //driver
    }

    @Override
    public void changeLocations(Long id, Double targetLong, Double targetLat, Double sourceLong, Double sourceLat) {
        Trip trip=tripRepository.findTripById(id).get();
        trip.setSourceLat(sourceLat);
        trip.setSourceLong(sourceLong);
        trip.setTargetLat(targetLat);
        trip.setTargetLong(targetLong);
        tripRepository.save(trip);
    }

    @Override
    public void changePrice(Long id) {
        Trip trip=tripRepository.findTripById(id).get();
        trip.setPrice((double) getRandomNumber(10000,200000));
        tripRepository.save(trip);
    }

    @Override
    public void changeState(Long id) {
        Trip trip1=tripRepository.findTripById(id).get();
        trip1.setState(1);
        tripRepository.save(trip1);
    }

    @Override
    public Trip selectTrip(Long id) {
        return tripRepository.findTripById(id).get();
    }

    @Override
    public Trip selectTripWithDriver(Driver driver, Integer state) {
        return tripRepository.findTripByDriverAndState(driver,state).get();
    }

    @Override
    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }
}
