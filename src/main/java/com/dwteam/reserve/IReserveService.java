package com.dwteam.reserve;

public interface IReserveService {
    Boolean endTrip(Long id);
    void changeDriver(Long id);
    void cancelTrip(Long id);
}
