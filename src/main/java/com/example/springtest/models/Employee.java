package com.example.springtest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmployeeId")
    private Integer id;

    @Column(name = "Title", length = 30)
    private String title;

    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(name = "HireDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supportRep")
    private List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "ReportsTo")
    private Employee reportsTo;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reportsTo")
    private List<Employee> employees;
}
