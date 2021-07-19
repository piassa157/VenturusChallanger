package com.challanger.venturus.controller;

import com.challanger.venturus.controller.dto.CustomerFormDTO;
import com.challanger.venturus.controller.dto.CustomersDTO;
import com.challanger.venturus.model.Customer;
import com.challanger.venturus.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping
    public List<CustomersDTO> list(){
        List<Customer> getCustomers = customerRepository.findAll();
        return CustomersDTO.convert(getCustomers);
    }

    @PostMapping
    public void create(@RequestBody CustomerFormDTO payload){
        Customer customer = payload.convert();
        customerRepository.save(customer);
    }


}
