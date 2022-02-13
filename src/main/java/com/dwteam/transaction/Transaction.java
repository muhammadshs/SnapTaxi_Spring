package com.dwteam.transaction;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import com.dwteam.trip.Trip;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Audited
@Table(name = "tbl_Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
    @NotNull
    @Column(name = "amount")
    private Double amount;


    @OneToOne
    @JoinColumn(name = "trip")
    private Trip trip;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

}
