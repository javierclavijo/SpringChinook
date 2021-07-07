package com.example.springtest.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Embeddable
public class Person {

    @Column(name = "FirstName", length = 40)
    private String firstName;

    @Column(name = "LastName", length = 20)
    private String lastName;

    @Column(name = "Address", length = 70)
    private String address;

    @Column(name = "City", length = 40)
    private String city;

    @Column(name = "State", length = 40)
    private String state;

    @Column(name = "Country", length = 40)
    private String country;

    @Column(name = "postalCode", length = 10)
    private String postalCode;
    
    @Column(name = "Phone", length = 24)
    private String phone;

    @Column(name = "Fax", length = 24)
    private String fax;

    @Column(name = "Email", length = 60)
    private String email;
}
