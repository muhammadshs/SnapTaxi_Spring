package com.dwteam.driver;

import java.util.Optional;

public interface IDriverService {
    String login(String userName,String passWord);
    void changeState(Long id,Integer state);
    Driver searchDriver(Integer state);
    Driver saveDriver(Driver driver);

}
