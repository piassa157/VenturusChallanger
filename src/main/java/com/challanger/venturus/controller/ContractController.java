package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.ContractDTO;
import com.challanger.venturus.controller.dto.ContractFormDTO;
import com.challanger.venturus.model.Contract;
import com.challanger.venturus.model.Customer;
import com.challanger.venturus.model.Provider;
import com.challanger.venturus.repository.ContractRepository;
import com.challanger.venturus.repository.CustomerRepository;
import com.challanger.venturus.repository.ProviderRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;
    private CustomerRepository customerRepository;
    private ProviderRepository providerRepository;

    @GetMapping
    public List<ContractDTO> list(String document){
        if(document == null){
            List<Contract> getContract = contractRepository.findAll();
            return ContractDTO.convert(getContract);
        }   else{
            List<Contract> getContractByDocumentCustomer = contractRepository.findContractByCustomerDocument(document);
                if(getContractByDocumentCustomer == null){
                    List<Contract> getContractByDocumentProvider = contractRepository.findContractByProviderDocument(document);

                    if(getContractByDocumentProvider == null){
                        List<Contract> getContractByNumber = contractRepository.findByContractNumber(document);

                        return ContractDTO.convert(getContractByDocumentProvider);
                    }

                    return ContractDTO.convert(getContractByDocumentProvider);
                }
            return ContractDTO.convert(getContractByDocumentCustomer);
        }
    }


    @PostMapping
    public void create(@RequestBody ContractFormDTO payload){
        Contract contract = payload.convert(payload.getCustomerDocument(), payload.getProviderDocument(), customerRepository, providerRepository);
        contractRepository.save(contract);
    }



}
