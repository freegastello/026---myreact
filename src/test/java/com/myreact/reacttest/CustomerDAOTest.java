package com.myreact.reacttest;

import com.myreact.reacttest.dao.CustomerDAO;
import com.myreact.reacttest.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CustomerDAOTest {
    private Session session;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerDAO customerDAO;

    @Before
    public void before() {
        session = sessionFactory.openSession();
    }

    @Test
    public void customerSaveTest() {
        Customer customer = new Customer();
        customer.setFirstName("First_");
        customer.setLastName("Last_");
        customer.setEmail("all@gmail.com");

        customerDAO.saveCustomer(customer);
        List<Customer> customerList = customerDAO.getCustomers();
        assertEquals(1, customerList.size());
    }

    @Test
    public void customerHQLTest() {
        /**
         * Тестирование HQL
         */
        List<Customer> customerList = customerDAO.getCustomers();
        assertEquals(0, customerList.size());

        createCustomer(2);

//  Работающий вариант 1:
        int correctResult = 2;
        String hql = "FROM Customer";
//        String hql = "SELECT c FROM Customer c";

//  Работающий вариант 2:
//        int correctResult = 1;
//        String hql = "SELECT c FROM Customer c WHERE c.firstName = '" + customer2.getFirstName() + "'";
//        String hql = "FROM Customer c WHERE c.firstName = '" + customer2.getFirstName() + "'";
//        String hql = "FROM Customer c WHERE c.firstName = '" + customer2.getFirstName() + "' AND c.lastName = '" + customer2.getLastName() + "'";
//        String hql = "FROM Customer c WHERE c.firstName = '" + customer2.getFirstName() + "' AND c.lastName = '" + customer2.getLastName() + "' AND c.id >= '" + customer2.getId() + "'";
        Query query = session.createQuery(hql);
        List<Customer> resultList = query.getResultList();

        assertEquals(correctResult, resultList.size());

        resultList.stream().forEach(el -> System.out.println(el));
    }

    @After
    public void after() {
//        session.close();
//        sessionFactory.close();
    }

    private void createCustomer(int num) {
        for (int i = 1; i <= num; i++) {
            Customer customer = new Customer();
            customer.setFirstName("First_" + i);
            customer.setLastName("Last_" + i);
            customer.setEmail("all_" + i + "@gmail.com");
            customerDAO.saveCustomer(customer);
        }
    }
}
