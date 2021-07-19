package com.challanger.venturus.repository;

import com.challanger.venturus.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByDocument(String document);
}
