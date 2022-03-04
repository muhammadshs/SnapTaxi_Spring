package com.dwteam.driver;

import com.dwteam.person.Person;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Audited
@Table(name = "tbl_Driver")
public class Driver extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Driver")
    private Long id;

    @NotNull
    @Column(name = "driverLicense", unique = true)
    private Long driverLicense;



    // @Column(name = "myLat")
    // private Double myLat;

    //@Column(name = "myLong")
    //private Double myLong;

    //@PrePersist
    //@CreationTimestamp
    //@PreUpdate
    //@PostLoad

}