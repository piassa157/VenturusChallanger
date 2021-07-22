package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.ContractDTO;
import com.challanger.venturus.controller.dto.ContractFormDTO;
import com.challanger.venturus.controller.dto.ContractUpdateFormDTO;
import com.challanger.venturus.model.Contract;
import com.challanger.venturus.repository.ContractRepository;
import com.challanger.venturus.repository.CustomerRepository;
import com.challanger.venturus.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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


//    @GetMapping
//    public Page<ContractDTO> index(){
//
//    }

    @GetMapping("{key}")
    @Transactional
    public List<ContractDTO> list(@PathVariable String key){
        if(key == null){
            List<Contract> getContract = contractRepository.findAll();
            return ContractDTO.convert(getContract);
        }   else{
            List<Contract> getContractByDocumentCustomer = contractRepository.findContractByCustomerDocument(key);
                if(getContractByDocumentCustomer.isEmpty()){
                    List<Contract> getContractByDocumentProvider = contractRepository.findContractByProviderDocument(key);

                    if(getContractByDocumentProvider.isEmpty()){
                        List<Contract> getContractByNumber = contractRepository.findByContractNumber(key);

                        return ContractDTO.convert(getContractByNumber);
                    }

                    return ContractDTO.convert(getContractByDocumentProvider);
                }
            return ContractDTO.convert(getContractByDocumentCustomer);
        }
    }


    @PostMapping
    @Transactional
    public ResponseEntity<ContractDTO> create(@RequestBody @Valid ContractFormDTO payload, UriComponentsBuilder uriBuilder){
        Contract contract = payload.convert(payload.getCustomerDocument(), payload.getProviderDocument(), customerRepository, providerRepository);
        contractRepository.save(contract);

        URI uri = uriBuilder.path("/contracts/{id}").buildAndExpand(contract.getId()).toUri();
        return  ResponseEntity.created(uri).body(new ContractDTO(contract));
    }


    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ContractDTO> update(@PathVariable Long id  ,@RequestBody ContractUpdateFormDTO payload){
            Contract contract = payload.update(id, contractRepository);

            return ResponseEntity.ok(new ContractDTO(contract));
    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        contractRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
