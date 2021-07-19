package com.challanger.venturus.repository;

import com.challanger.venturus.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.Assert;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void souldCarryCustomerByDocument(){
        String customerDocument = "99987667812";
        Customer customer = customerRepository.findByDocument(customerDocument);
        Assert.assertNotNull(customer);
        Assert.assertEquals(customerDocument, customer.getDocument());
    }

}
