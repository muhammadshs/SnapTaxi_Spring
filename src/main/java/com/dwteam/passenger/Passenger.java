package com.dwteam.passenger;


import com.dwteam.person.Person;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Data
@Audited
@Table(name = "tbl_Passenger")
public class Passenger extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Passenger")
    private Long id;




    //@Column(name = "myLat")
    //private Double myLat;

    //@Column(name = "myLong")
    //private Double myLong;


}
