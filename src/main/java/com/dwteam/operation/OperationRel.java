package com.dwteam.operation;

import javax.persistence.*;
@Entity
public class OperationRel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_OR")
    private Long id;

    @Column(name = "typePerson")
    @Enumerated(EnumType.ORDINAL)
    private PersonalType type;

    @ManyToOne
    private Per
}
