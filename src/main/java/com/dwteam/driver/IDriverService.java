package com.dwteam.driver;

public interface IDriverService {
    Long login(String userName,String passWord);
    void changeMyLocation(Long id,Double myLat,Double myLong);
    Boolean endTrip(Long id);
}
