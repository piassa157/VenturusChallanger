package com.challanger.venturus.repository;

import com.challanger.venturus.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    List<Contract> findContractByCustomerDocument(String document);

    List<Contract> findContractByProviderDocument(String document);
}
