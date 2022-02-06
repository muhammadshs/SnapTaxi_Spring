package com.dwteam.location;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Location")
    private Long id;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @OneToOne(mappedBy = "location")
    private Driver driver;

    @OneToOne(mappedBy = "location")
    private Passenger passenger;



}
