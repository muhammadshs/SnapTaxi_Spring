package com.dwteam.driver;

import java.util.Optional;

public interface IDriverService {
    Long login(String userName,String passWord);
    void changeState(Long id,Integer state);
    Driver searchDriver(Integer state);
    void saveDriver(Driver driver);
}
