package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Contract;
import com.challanger.venturus.model.Customer;
import com.challanger.venturus.model.Provider;
import com.challanger.venturus.repository.CustomerRepository;
import com.challanger.venturus.repository.ProviderRepository;
import com.challanger.venturus.util.DataUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ContractFormDTO {
    private static final Logger logger = LogManager.getLogger(ContractFormDTO.class);


    @NotNull @NotEmpty
    private String subName;
    private String serviceName;
    @NotNull
    private Date startedDate;
    @NotNull
    private Date closedDate;
    @NotNull @NotEmpty @Size(min = 11)
    private String customerDocument;
    @NotNull @NotEmpty @Size(min = 11)
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contract convert(String customerDocument, String providerDocument, CustomerRepository customerRepository, ProviderRepository providerRepository) {
        return new Contract(subName, serviceName,startedDate, closedDate, provider, customer);
    }

}
