package com.challanger.venturus.controller.dto;

import com.challanger.venturus.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomersDTO {

    private String socialName;
    private String document;


    public CustomersDTO(Customer customer){
        this.socialName = customer.getSocialName();
        this.document = customer.getDocument();
    }

    public String getSocialName() {
        return socialName;
    }

    public String getDocument() {
        return document;
    }

    public static List<CustomersDTO> convert(List<Customer> getCustomers) {
        return getCustomers.stream().map(CustomersDTO::new).collect(Collectors.toList());
    }
}
