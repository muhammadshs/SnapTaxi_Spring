package com.dwteam.passenger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends PagingAndSortingRepository<Passenger,Long> {
}
