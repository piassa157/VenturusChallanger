package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Contract;
import com.challanger.venturus.model.Customer;
import com.challanger.venturus.model.Provider;
import com.challanger.venturus.repository.CustomerRepository;
import com.challanger.venturus.repository.ProviderRepository;
import com.challanger.venturus.util.DataUtil;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ContractFormDTO {

    @NotNull @NotEmpty
    private String subName;
    @NotNull
    private Date startedDate;
    @NotNull
    private Date closedDate;
    @NotNull @NotEmpty @Size(min = 12)
    private String customerDocument;
    @NotNull @NotEmpty @Size(min = 12)
    private String providerDocument;
    private Provider provider;
    private Customer customer;

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }


    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public String getCustomerDocument() {
        return customerDocument;
    }

    public void setCustomerDocument(String customerDocument) {
        this.customerDocument = customerDocument;
    }

    public String getProviderDocument() {
        return providerDocument;
    }

    public void setProviderDocument(String providerDocument) {
        this.providerDocument = providerDocument;
    }

    public Contract convert(String customerDocument, String providerDocument, CustomerRepository customerRepository, ProviderRepository providerRepository) {
        return new Contract(subName, startedDate, closedDate, provider, customer);
    }

}
