package com.example.springtest.repositories;

import com.example.springtest.models.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Integer> {
}