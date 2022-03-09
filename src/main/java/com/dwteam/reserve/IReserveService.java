package com.dwteam.reserve;

public interface IReserveService {
    void endTrip(Long id);
    void changeDriver(Long id);
    void cancelTrip(Long id);
    void createTrip(Long idPassenger);
}
