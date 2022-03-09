package com.dwteam.operation;

import com.dwteam.person.Person;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Data
@Audited
public class PersonOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_PO")
    private Long id;


    @Column(name = "url_Api")
    private String url_Api;
}
