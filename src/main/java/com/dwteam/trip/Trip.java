package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import com.dwteam.transaction.Transaction;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tbl_Trip")
@Data
@Audited
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Trip")
    private Long id;
    @NotNull
    @Column(name = "price")
    private Double price;
    @NotNull
    @ManyToOne
    private Passenger passenger;
    @NotNull
    @ManyToOne
    private Driver driver;
    //change to enum
    //get check
    @NotNull
    @Column(name = "state",columnDefinition="integer default '0'")
    private Integer state;
    //change to prepersist
    //time stamp
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatDate;
    @NotNull
    @Column(name = "sourceLat")
    private Double sourceLat;
    @NotNull
    @Column(name = "sourceLong")
    private Double sourceLong;
    @NotNull
    @Column(name = "targetLat")
    private Double targetLat;
    @NotNull
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
