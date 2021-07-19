package com.challanger.venturus.repository;

import com.challanger.venturus.model.Contract;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ContractRepositoryTest {

    @Autowired
    private ContractRepository contractRepository;

    @Test
    public void notShouldCarryContractByNumber(){
        String contractNumber = "123";
        List<Contract> contract = contractRepository.findByContractNumber(contractNumber);
        contract.forEach(it -> {
            Assert.assertNull(it);
        });
    }



}
