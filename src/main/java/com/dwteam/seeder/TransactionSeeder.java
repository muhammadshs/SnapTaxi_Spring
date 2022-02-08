package com.dwteam.seeder;

import com.dwteam.driver.Driver;
import com.dwteam.driver.DriverRepository;
import com.dwteam.passenger.PassengerRepository;
import com.dwteam.transaction.Transaction;
import com.dwteam.transaction.TransactionRepository;
import com.dwteam.trip.Trip;
import com.dwteam.trip.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
public class TransactionSeeder implements ApplicationRunner {
    TransactionRepository transactionRepository;
    TripRepository tripRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i=200;i<450;i++){
            Transaction transaction=new Transaction();
            transaction.setAmount( 2222.2+i);
            transaction.setTrip(tripRepository.findById(Long.valueOf(i)).get());
            transaction.setDate(new Date());
            transactionRepository.save(transaction);
        }
    }
}
