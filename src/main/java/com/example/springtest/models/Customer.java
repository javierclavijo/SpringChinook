package com.example.springtest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustomerId")
    private Integer id;

    @Embedded
    private Person person;

    @Column(name = "Company", length = 80)
    private String company;

    @ManyToOne
    @JoinColumn(name = "SupportRepId")
    private Employee supportRep;

    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoices;

}
