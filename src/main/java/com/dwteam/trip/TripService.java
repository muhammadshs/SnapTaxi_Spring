package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.driver.DriverService;
import com.dwteam.exceptions.NotFindExp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TripService implements ITripService {
    TripRepository tripRepository;
    DriverService driverService;

    @Override
    public Trip creatTrip(Trip trip) {

        trip.setPrice((double) getRandomNumber(10000, 200000));
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
    public Trip findByPassengerIdAndState(Long id) {
        Optional<Trip> optionalTrip = tripRepository.findByPassenger_IdAndState(id,0);
        if (optionalTrip.isPresent()) {
            return optionalTrip.get();
        } else {
            throw new NotFindExp("Cant find Trip with this id",this.getClass().getName());

        }
    }



   /* @Override
    public void changeLocations(Long id, Double targetLong, Double targetLat, Double sourceLong, Double sourceLat) {
        Optional<Trip> op = tripRepository.findById(id);
        op.ifPresentOrElse(trip -> {
            trip.setSourceLat(sourceLat);
            trip.setSourceLong(sourceLong);
            trip.setTargetLat(targetLat);
            trip.setTargetLong(targetLong);
            tripRepository.save(trip);
        }, () -> {
            throw new NotFindExp("Cant find Trip with this id");
        });
    }*/

    @Override
    public void changePrice(Long id) {
        Optional<Trip> optrip = tripRepository.findById(id);
        optrip.ifPresentOrElse(trip -> {
                    trip.setPrice((double) getRandomNumber(10000, 200000));
                    tripRepository.save(trip);
                },
                () -> {
                    throw new NotFindExp("Cant find Trip with this id",this.getClass().getName());
                });

    }

    @Override
    public void changeState(Long id, Integer state) {
        tripRepository.findById(id).ifPresentOrElse(trip1 -> {
                    trip1.setState(state);
                    tripRepository.save(trip1);
                },
                () -> {
                    throw new NotFindExp("Cant find Trip with this id",this.getClass().getName());
                });

    }

    @Override
    public Trip selectTrip(Long id) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            return optionalTrip.get();
        } else {
            throw new NotFindExp("Cant find Trip with this id",this.getClass().getName());

        }
    }

    @Override
    public Trip selectTripWithDriver(Driver driver, Integer state) {
        Optional<Trip> optionalTrip = tripRepository.findByDriverAndState(driver, state);
        if (optionalTrip.isPresent()) {
            return optionalTrip.get();
        } else {
            throw new NotFindExp("Cant find Trip with this id",this.getClass().getName());

        }
    }

    @Override
    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }
}
