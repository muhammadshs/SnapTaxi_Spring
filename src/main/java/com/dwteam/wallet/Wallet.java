package com.dwteam.wallet;

import com.dwteam.driver_account.DriverAcc;
import com.dwteam.passenger_account.PassengerAcc;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_Wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Wallet")
    private Long id;

    @Column(name = "balance")
    private Double balance;

    @OneToOne(mappedBy = "wallet")
    private DriverAcc driverAcc;

    @OneToOne(mappedBy = "wallet")
    private PassengerAcc passengerAcc;
}
