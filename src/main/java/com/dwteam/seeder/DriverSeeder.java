package com.dwteam.seeder;

import com.dwteam.driver.Driver;
import com.dwteam.driver.DriverRepository;
import com.dwteam.passenger.PassengerRepository;
import com.dwteam.transaction.TransactionRepository;
import com.dwteam.trip.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


public class DriverSeeder implements ApplicationRunner {
    DriverRepository driverRepository;
    @Autowired
    public DriverSeeder(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i=1;i<1000;i++){
            Driver driver=new Driver();
            driver.setDriverLicense(123456789l+i);
           // driver.setMyLat(2.333333+i);
           // driver.setMyLong(2.3333+i);
            driver.setPhoneNumber(9017321775l+i);
            driver.setBalance(3481347.844+i);
            driver.setPassWord("mx134577"+i);
            driver.setUserName("mohammad"+i);
            driver.setState(0);
            driverRepository.save(driver);
        }
    }
}
