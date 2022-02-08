package com.dwteam.driver;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<Driver,Long> {
    Driver findDriverByUserNameAndPassWord(String userName,String passWord);
    List<Driver> findByState(Integer state);

}
