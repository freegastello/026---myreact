package com.myreact.reacttest;

import com.myreact.reacttest.entity.Customer;
import com.myreact.reacttest.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    public void initTest() {
        Customer customer = new Customer();
        customer.setFirstName("First_");
        customer.setLastName("Last_");
        customer.setEmail("all@gmail.com");

        customerService.saveCustomer(customer);
        List<Customer> customerList = customerService.getCustomers();
        assertEquals(1, customerList.size());
    }
}
