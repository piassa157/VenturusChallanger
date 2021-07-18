package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Contract;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ContractDTO {

    private Long contractNumber;
    private String subName;
    private String validaty;
    private LocalDateTime startedDate;
    private Date closedDate;

    public ContractDTO(Contract contract){
        this.contractNumber = contract.getContractNumber();
        this.subName = contract.getSubName();
        this.validaty = contract.getValidaty();
        this.startedDate = contract.getStartedContract();
        this.closedDate = contract.getClosedContract();
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public String getSubName() {
        return subName;
    }

    public String getValidaty() {
        return validaty;
    }

    public LocalDateTime getStartedDate() {
        return startedDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public static List<ContractDTO> convert(List<Contract> contracts){
        return contracts.stream().map(ContractDTO::new).collect(Collectors.toList());
    }
}