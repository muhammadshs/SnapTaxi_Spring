package com.dwteam.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService {
    LocationRepository locationRepository;
    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void Save(Location location) {
        locationRepository.save(location);
    }
}
