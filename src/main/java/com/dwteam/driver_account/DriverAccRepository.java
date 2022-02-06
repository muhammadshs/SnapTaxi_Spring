package com.dwteam.driver_account;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverAccRepository extends PagingAndSortingRepository<DriverAcc,Long> {
}
