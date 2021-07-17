package com.challanger.venturus.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long contractNumber;
    private String subName;
    private String validaty;
    private LocalDateTime startedContract;
    private Date closedContract;
    @ManyToOne
    private Provider provider;
    @ManyToOne
    private Customer client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public LocalDateTime getStartedContract() {
        return startedContract;
    }

    public void setStartedContract(LocalDateTime startedContract) {
        this.startedContract = startedContract;
    }

    public Date getClosedContract() {
        return closedContract;
    }

    public void setClosedContract(Date closedContract) {
        this.closedContract = closedContract;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Customer getClient() {
        return client;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    public String getValidaty() {
        return validaty;
    }

    public void setValidaty(String validaty) {
        this.validaty = validaty;
    }
}
