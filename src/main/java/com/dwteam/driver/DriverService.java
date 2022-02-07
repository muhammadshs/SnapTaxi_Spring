package com.dwteam.driver;

import com.dwteam.location.Location;
import com.dwteam.location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService implements IDriverService {
    DriverRepository driverRepository;
    LocationRepository locationRepository;
    @Autowired
    public DriverService(DriverRepository driverRepository, LocationRepository locationRepository) {
        this.driverRepository = driverRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Long login(String userName, String passWord) {
        Driver driver = driverRepository.findByUserNameAndPassWord(userName, passWord).get();
        return driver.getId();
    }

    /*@Override
    public void changeLocation(Double latitude, Double longitude,Long token) {
        Optional<Location> opLoc=locationRepository.findByLatitudeAndLongitude(latitude, longitude);
        Optional<Driver> op= driverRepository.findByDriverAcc_Id(token);
        Driver driver=op.get();
        Location location;
        if(opLoc.isEmpty()){
            location=new Location();
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            driver.setLocation(locationRepository.save(location));
            driverRepository.save(driver);
        }
        else{
            location=opLoc.get();
            location.setLongitude(longitude);
            location.setLatitude(latitude);
            driver.setLocation(location);
            driverRepository.save(driver);
        }

    }*/

    @Override
    public Boolean changeUserName(String userName) {
        return null;
    }

    @Override
    public Boolean changePassWord(String passWord) {
        return null;
    }
}
