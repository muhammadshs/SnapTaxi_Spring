package com.dwteam.transaction;

import com.dwteam.trip.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction,Long> {
    Boolean existsByTrip(Trip trip);
}
