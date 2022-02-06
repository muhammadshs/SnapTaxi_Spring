package com.dwteam.passenger;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PassengerRepository extends PagingAndSortingRepository<Passenger,Long> {
    Optional<Passenger> findByUserNameAndPassWord(String userName,String passWord);
}
