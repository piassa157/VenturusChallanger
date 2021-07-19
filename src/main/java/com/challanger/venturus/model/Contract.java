package com.challanger.venturus.model;

import com.challanger.venturus.util.RandomString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contractNumber = new RandomString().getAlphaNumericString();
    private String subName;
    private String validaty;
    private LocalDateTime startedContract;
    private Date closedContract;
    @ManyToOne
    private Provider provider;
    @ManyToOne
    private Customer customer;

    public Contract(){

    }

    public Contract(String subName, String validaty, LocalDateTime startedContract, Date closedContract, Provider provider, Customer customer) {
        this.subName = subName;
        this.validaty = validaty;
        this.startedContract = startedContract;
        this.closedContract = closedContract;
        this.provider = provider;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
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
        return customer;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }

    public String getValidaty() {
        return validaty;
    }

    public void setValidaty(String validaty) {
        this.validaty = validaty;
    }
}
