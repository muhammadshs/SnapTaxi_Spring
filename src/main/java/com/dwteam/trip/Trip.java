package com.dwteam.trip;

import com.dwteam.driver_account.DriverAcc;
import com.dwteam.location.Location;
import com.dwteam.passenger_account.PassengerAcc;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Trip")
@Data
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Trip")
    private Long id;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    private PassengerAcc passengerAcc;


    @ManyToOne
    private DriverAcc driverAcc;

    @Column(name = "date")
    private Date data;


    private Location lcation;


}
