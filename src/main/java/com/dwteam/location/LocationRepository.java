package com.dwteam.location;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends PagingAndSortingRepository<Location,Long> {
    Optional<Location> findByLatitudeAndLongitude(Double latitude,Double longitude);
}
