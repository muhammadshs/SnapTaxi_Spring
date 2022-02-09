package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import com.dwteam.transaction.Transaction;
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
    private Passenger passenger;

    @ManyToOne
    private Driver driver;
    //change to enum
    @Column(name = "state")
    private Integer state;
    //change to prepersist
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date creatDate;

    @Column(name = "sourceLat")
    private Double sourceLat;

    @Column(name = "sourceLong")
    private Double sourceLong;

    @Column(name = "targetLat")
    private Double targetLat;

    @Column(name = "targetLong")
    private Double targetLong;

    @OneToOne(mappedBy = "trip")
    private Transaction transaction;

    @PrePersist
    void dateSetter(){
        creatDate=new Date();
    }
    //Controller Advice
}
