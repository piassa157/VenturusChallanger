package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.CustomersDTO;
import com.challanger.venturus.model.Customer;
import com.challanger.venturus.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @RequestMapping("/customers")
    public List<CustomersDTO> list(){
        List<Customer> getCustomers = customerRepository.findAll();

        return CustomersDTO.convert(getCustomers);
    }


}
