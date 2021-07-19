package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Customer;

public class CustomerFormDTO {
    private String socialName;
    private String document;

    public CustomerFormDTO(){

    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Customer convert() {
        return  new Customer(this.socialName, this.document);
    }
}
