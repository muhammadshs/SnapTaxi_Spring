package com.dwteam.driver;

import lombok.Data;
import org.hibernate.envers.Audited;


import javax.persistence.*;

@Entity
@Data
@Audited
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

    @Column(name = "driverLicense",unique = true)
    private Long driverLicense;

    @Column(name = "state")
    private Integer state;

    @Column(name = "balance")
    private Double balance;

   // @Column(name = "myLat")
   // private Double myLat;

    //@Column(name = "myLong")
    //private Double myLong;

    //@PrePersist
    //@CreationTimestamp
    //@PreUpdate
    //@PostLoad
}