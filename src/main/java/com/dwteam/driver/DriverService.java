package com.dwteam.driver;

import com.dwteam.trip.ITripService;
import com.dwteam.trip.Trip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DriverService implements IDriverService{
    DriverRepository driverRepository;
    ITripService tripService;
    @Override
    public Long login(String userName, String passWord) {
        Driver driver=driverRepository.findDriverByUserNameAndPassWord(userName, passWord);
        return driver.getId();
    }

    @Override
    public void changeMyLocation(Long id,Double myLat, Double myLong) {
        Optional<Driver> op=driverRepository.findById(id);
        if(op.isPresent())
        {
            Driver driver=op.get();
            driver.setMyLong(myLong);
            driver.setMyLat(myLat);
            driverRepository.save(driver);
        }
    }

    @Override
    public Boolean endTrip(Long id) {
        Optional<Driver> op=driverRepository.findById(id);
        Driver driver=op.get();
        driver.setState(0);
        driverRepository.save(driver);
        Trip trip=tripService.selectTripWithDriver(driver,0);
        trip.setState(1);
        tripService.saveTrip(trip);
        return null;
    }
}
