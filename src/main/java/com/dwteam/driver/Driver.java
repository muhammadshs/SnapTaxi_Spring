package com.dwteam.driver;

import com.dwteam.driver_account.DriverAcc;
import com.dwteam.location.Location;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_Driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Driver")
    private Long id;

    @Column(name = "userName",unique = true)
    private String userName;

    @Column(name = "passWord")
    private String passWord;

    @Column(name = "phoneNumber",unique = true)
    private Long phoneNumber;

    @Column(name = "onlineState")
    private Boolean onlineState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Location", referencedColumnName = "id_Location")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_DriverAcc",referencedColumnName = "id_DriverAcc")
    private DriverAcc driverAcc;
}