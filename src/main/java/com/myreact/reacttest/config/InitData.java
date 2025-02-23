package com.myreact.reacttest.config;

import com.myreact.reacttest.entity.Customer;
import com.myreact.reacttest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitData {

    @Autowired
    private CustomerService customerService;

    public void initData() {
        generateEntityAnimals();
    }

    private void generateEntityAnimals() {
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            customer.setEmail("email_" + i + "@gmail.com");
            customer.setFirstName("First_" + i);
            customer.setLastName("Last_" + i);
            customerService.saveCustomer(customer);
        }
    }
}
