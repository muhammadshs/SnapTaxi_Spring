package com.dwteam.driver;

import com.dwteam.driver_account.DriverAcc;

public interface IDriverService {
    Long login(String userName,String passWord);
    void changeLocation(Double latitude,Double longitude,Long token);
    Boolean changeUserName(String userName);
    Boolean changePassWord(String passWord);
}
