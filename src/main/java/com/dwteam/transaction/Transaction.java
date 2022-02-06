package com.dwteam.transaction;

import com.dwteam.driver.Driver;
import com.dwteam.driver_account.DriverAcc;
import com.dwteam.passenger.Passenger;
import com.dwteam.passenger_account.PassengerAcc;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    private PassengerAcc passengerAcc;

    @ManyToOne(cascade = CascadeType.ALL)
    private DriverAcc driverAcc;

    @Column(name = "date")
    private Date date;

}
