package com.dwteam.passenger_account;

import com.dwteam.passenger.Passenger;
import com.dwteam.transaction.Transaction;
import com.dwteam.trip.Trip;
import com.dwteam.wallet.Wallet;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_PassengerAcc")
@Data
public class PassengerAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_PassengerAcc")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Passenger passenger;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactionList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trip> trip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Wallet",referencedColumnName = "id_Wallet")
    private Wallet wallet;
}
