package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.ContractDTO;
import com.challanger.venturus.controller.dto.ContractFormDTO;
import com.challanger.venturus.model.Contract;
import com.challanger.venturus.repository.ContractRepository;
import com.challanger.venturus.repository.CustomerRepository;
import com.challanger.venturus.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
                if(getContractByDocumentCustomer.isEmpty()){
                    List<Contract> getContractByDocumentProvider = contractRepository.findContractByProviderDocument(document);

                    if(getContractByDocumentProvider.isEmpty()){
                        List<Contract> getContractByNumber = contractRepository.findByContractNumber(document);

                        return ContractDTO.convert(getContractByNumber);
                    }

                    return ContractDTO.convert(getContractByDocumentProvider);
                }
            return ContractDTO.convert(getContractByDocumentCustomer);
        }
    }


    @PostMapping
    public ResponseEntity<ContractDTO> create(@RequestBody @Valid ContractFormDTO payload, UriComponentsBuilder uriBuilder){
        Contract contract = payload.convert(payload.getCustomerDocument(), payload.getProviderDocument(), customerRepository, providerRepository);
        contractRepository.save(contract);

        URI uri = uriBuilder.path("/contracts/{id}").buildAndExpand(contract.getId()).toUri();
        return  ResponseEntity.created(uri).body(new ContractDTO(contract));
    }

}
