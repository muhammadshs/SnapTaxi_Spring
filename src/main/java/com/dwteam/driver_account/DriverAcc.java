package com.dwteam.driver_account;

import com.dwteam.driver.Driver;
import com.dwteam.transaction.Transaction;
import com.dwteam.trip.Trip;
import com.dwteam.wallet.Wallet;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_DriverAcc")
public class DriverAcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_DriverAcc")
    private Long id;

    @OneToOne(mappedBy = "driverAcc")
    private Driver driver;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactionList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trip> trip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Wallet",referencedColumnName = "id_Wallet")
    private Wallet wallet;
}
