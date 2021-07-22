package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Contract;
import com.challanger.venturus.repository.ContractRepository;

public class ContractUpdateFormDTO {

    private String subName;
    private String serviceName;

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Contract update(Long id, ContractRepository contractRepository) {
        Contract contract = contractRepository.getById(id);

        if(this.serviceName != null){
            contract.setServiceName(this.serviceName);
        }

        if(this.subName != null) {
            contract.setSubName(this.subName);
        }

        return contract;
    }
}
