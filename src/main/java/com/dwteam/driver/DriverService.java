package com.dwteam.driver;

import com.dwteam.exception.ConflictExp;
import com.dwteam.exception.NotFindExp;
import com.dwteam.jwt.Token;
import com.dwteam.passenger.Passenger;
import com.dwteam.trip.ITripService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DriverService implements IDriverService {
    DriverRepository driverRepository;
    Token token;

    @Override
    public String login(String userName, String passWord) {
        Optional<Driver> op=driverRepository.findByUserNameAndPassWord(userName,passWord);
        if(op.isEmpty()){
            throw new NotFindExp("cant find Passenger",this.getClass().getName());
        }
            Long id=op.get().getId();
        String tokenStr="";
        try {
            tokenStr=token.CreateToken_HS256(userName,id);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tokenStr;
    }


    @Override
    public void changeState(Long id, Integer state) {
        Optional<Driver> op = driverRepository.findById(id);
        op.ifPresentOrElse(driver -> {
            driver.setState(0);
            driverRepository.save(driver);
        }, () -> {
            throw new NotFindExp("Cant find Driver with this id",this.getClass().getName());
        });

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public Driver searchDriver(Integer state) {
        List<Driver> list = driverRepository.findAllByState(state);
        if (list.size()==0) {
            throw new NotFindExp("Cant find Driver with this id",this.getClass().getName());
        }

        return list.get(getRandomNumber(0,list.size()));
    }

    @Override
    public Driver saveDriver(Driver driver) {
        if(driverRepository.existsByUserNameOrDriverLicenseOrPhoneNumber(driver.getUserName(),driver.getDriverLicense(),driver.getPhoneNumber())){
            throw new ConflictExp("this driver exists",this.getClass().getName());
        }
        return driverRepository.save(driver);
    }




}
