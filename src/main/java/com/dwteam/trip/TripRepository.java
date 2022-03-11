package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip,Long> {
    Boolean deleteByPassenger_IdAndState(Long passengerId , Integer state);
    Optional<Trip> findByPassenger_IdAndState(Long passengerId,Integer state);
    Optional<Trip> findById(Long id);
    Optional<Trip> findByDriverAndState(Driver driver, Integer state);
}
