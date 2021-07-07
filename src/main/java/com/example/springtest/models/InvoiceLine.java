package com.example.springtest.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InvoiceLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "InvoiceLineId")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "InvoiceId")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "TrackId")
    private Track track;

    @Column(name = "UnitPrice", length = 10, precision = 2)
    private Double unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

}
