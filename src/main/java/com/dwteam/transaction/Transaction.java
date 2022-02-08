package com.dwteam.transaction;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import com.dwteam.trip.Trip;
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


    @OneToOne
    @JoinColumn(name = "trip")
    private Trip trip;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

}
