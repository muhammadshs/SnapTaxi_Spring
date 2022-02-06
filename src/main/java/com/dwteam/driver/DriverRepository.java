package com.dwteam.driver;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<Driver,Long> {
    Optional<Driver> findByUserNameAndPassWord(String userName, String passWord);
    Optional<Driver> findByDriverAcc_Id(Long id);
}
