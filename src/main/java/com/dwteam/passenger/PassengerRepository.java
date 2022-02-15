package com.dwteam.passenger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends PagingAndSortingRepository<Passenger,Long> {
    Optional<Passenger> findByUserNameAndPassWord(String userName,String passWord);
    Boolean existsByUserNameOrPhoneNumber(String userName,Long passWord);
}
