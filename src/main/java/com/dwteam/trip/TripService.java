package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.driver.DriverService;
import com.dwteam.passenger.Passenger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TripService implements ITripService {
    TripRepository tripRepository;
    DriverService driverService;

    @Override
    public Trip creatTrip(Passenger passenger, Driver driver, Double sourceLat, Double sourceLong, Double targetLat, Double targetLong) {
        Trip trip = new Trip();
        trip.setTargetLong(targetLong);
        trip.setPassenger(passenger);
        trip.setTargetLat(targetLat);
        trip.setPrice((double) getRandomNumber(10000, 200000));
        trip.setDriver(driver);
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

        return tripRepository.deleteByPassenger_IdAndState(passengerId, state);
    }

    @Override
    public void changeDriver(Long id) {
        tripRepository.findById(id).ifPresentOrElse(trip1 -> {
            driverService.changeState(trip1.getDriver().getId(), 0);
            trip1.setDriver(driverService.searchDriver(0));
            tripRepository.save(trip1);
        }, () -> {
            System.out.println("error");
        });

    }

    @Override
    public void changeLocations(Long id, Double targetLong, Double targetLat, Double sourceLong, Double sourceLat) {
        Optional<Trip> op = tripRepository.findById(id);
        op.ifPresentOrElse(trip -> {
            trip.setSourceLat(sourceLat);
            trip.setSourceLong(sourceLong);
            trip.setTargetLat(targetLat);
            trip.setTargetLong(targetLong);
            tripRepository.save(trip);
        }, () -> {
            System.err.println("errr");
        });

    }

    @Override
    public void changePrice(Long id) {
        Optional<Trip> optrip = tripRepository.findById(id);
        optrip.ifPresentOrElse(trip -> {
                    trip.setPrice((double) getRandomNumber(10000, 200000));
                    tripRepository.save(trip);
                },
                () -> {
                    System.err.println("errr");
                });

    }

    @Override
    public void changeState(Long id, Integer state) {
        tripRepository.findById(id).ifPresentOrElse(trip1 -> {
                    trip1.setState(state);
                    tripRepository.save(trip1);
                },
                () -> {
                    System.err.println("errr");
                });

    }

    @Override
    public Trip selectTrip(Long id) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            return optionalTrip.get();
        } else {
            System.err.println("errrr");
            return null;
        }
    }

    @Override
    public Trip selectTripWithDriver(Driver driver, Integer state) {
        Optional<Trip> optionalTrip = tripRepository.findByDriverAndState(driver, state);
        if (optionalTrip.isPresent()) {
            return optionalTrip.get();
        } else {
            System.err.println("errrr");
            return null;
        }
    }

    @Override
    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }
}
