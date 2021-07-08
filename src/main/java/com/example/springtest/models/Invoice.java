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
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "InvoiceId")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "InvoiceDate")
    private Date invoiceDate;

    @Column(name = "BillingAddress", length = 70)
    private String billingAddress;

    @Column(name = "BillingCity", length = 40)
    private String billingCity;

    @Column(name = "BillingState", length = 40)
    private String billingState;

    @Column(name = "BillingCountry", length = 40)
    private String billingCountry;

    @Column(name = "BillingPostalCode", length = 10)
    private String billingPostalCode;

    @Column(name = "Total", length = 10, precision = 2)
    private Double total;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
    private List<InvoiceLine> invoiceLines;

}
