package com.dwteam.wallet;

import com.dwteam.driver_account.DriverAcc;
import com.dwteam.passenger_account.PassengerAcc;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends PagingAndSortingRepository<Wallet,Long> {
    Optional<Wallet> findById(Long id);
    Optional<Wallet> findByPassengerAcc(PassengerAcc passengerAcc);
    Optional<Wallet> findByDriverAcc(DriverAcc driverAcc);
}
