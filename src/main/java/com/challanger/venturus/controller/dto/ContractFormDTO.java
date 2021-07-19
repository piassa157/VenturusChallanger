package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Contract;
import com.challanger.venturus.model.Customer;
import com.challanger.venturus.model.Provider;
import com.challanger.venturus.repository.CustomerRepository;
import com.challanger.venturus.repository.ProviderRepository;
import com.challanger.venturus.util.RandomString;

import java.time.LocalDateTime;
import java.util.Date;

public class ContractFormDTO {

    private String subName;
    private String validaty;
    private LocalDateTime startedDate;
    private Date closedDate;
    private String customerDocument;
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

    public String getValidaty() {
        return validaty;
    }

    public void setValidaty(String validaty) {
        this.validaty = validaty;
    }

    public LocalDateTime getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDateTime startedDate) {
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
        return new Contract(subName, validaty, startedDate, closedDate, provider, customer);
    }

}
