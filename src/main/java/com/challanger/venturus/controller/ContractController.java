package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.ContractDTO;
import com.challanger.venturus.model.Contract;
import com.challanger.venturus.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;

    @RequestMapping("/contracts")
    public List<ContractDTO> list(){
        List<Contract> getContract = contractRepository.findAll();
        return ContractDTO.convert(getContract);
    }

}
