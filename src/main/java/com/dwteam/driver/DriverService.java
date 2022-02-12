package com.dwteam.driver;

import com.dwteam.exception.NotFindExp;
import com.dwteam.trip.ITripService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DriverService implements IDriverService {
    DriverRepository driverRepository;
    ITripService tripService;

    @Override
    public Long login(String userName, String passWord) {
        Driver driver = driverRepository.findDriverByUserNameAndPassWord(userName, passWord);
        return driver.getId();
    }


    @Override
    public void changeState(Long id, Integer state) {
        Optional<Driver> op = driverRepository.findById(id);
        op.ifPresentOrElse(driver -> {
            driver.setState(0);
            driverRepository.save(driver);
        }, () -> {
            throw new NotFindExp("Cant find Driver with this id");
        });

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public Driver searchDriver(Integer state) {
        List<Driver> list = driverRepository.findAllByState(state);
        if (list.size()==0) {
            throw new NotFindExp("Cant find Driver with this id");
        }

        return list.get(getRandomNumber(0,list.size()));
    }

    @Override
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }


}
