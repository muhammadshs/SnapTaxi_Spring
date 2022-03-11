package com.dwteam.reserve;

import com.dwteam.driver.Driver;
import com.dwteam.driver.IDriverService;
import com.dwteam.passenger.IPassengerService;
import com.dwteam.trip.ITripService;
import com.dwteam.trip.Trip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReserveService implements IReserveService{
    private IDriverService driverService;
    private IPassengerService passengerService;
    private ITripService tripService;
    @Override
    public void endTrip(Long idPassenger) {

        Trip trip=tripService.findByPassengerIdAndState(idPassenger);
        Long driverId=trip.getDriver().getId();
        Long passengerId=trip.getPassenger().getId();
        //----------number 0 in state meaning driver is free
        driverService.changeState(driverId,0);
        //----------number 2 for cancel trip
        tripService.changeState(trip.getId(),2);
        //----------number 0 in state meaning passenger is free
        passengerService.changeState(passengerId,0);



    }
    // this method 
    @Override
    public void changeDriver(Long id) {
        Trip trip=tripService.selectTrip(id);
            driverService.changeState(trip.getDriver().getId(), 0);
            trip.setDriver(driverService.searchDriver(0));
            tripService.saveTrip(trip);

    }

    @Override
    public void cancelTrip(Long id) {
        Trip trip=tripService.selectTrip(id);
        Driver driver=trip.getDriver();
        driver.setState(0);
        trip.setDriver(driverService.searchDriver(0));
        tripService.saveTrip(trip);
        driverService.saveDriver(driver);
    }

    @Override
    public void createTrip(Long idPassenger) {
        
    }

}
