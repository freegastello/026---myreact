package com.myreact.reacttest;

import com.myreact.reacttest.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class SessionTest {
    private Session session;
    private Transaction tx;

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void before() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    @Test
    public void nativeQuerySelectTest() {
        Query query = session.createNativeQuery("SELECT * FROM demo_db.customer");
        List<Customer> customerList = query.getResultList();
        assertEquals(0, customerList.size());

        Customer customer = new Customer();
        customer.setFirstName("testName_");
        customer.setLastName("test2LastName_");
        customer.setEmail("testEmail_@test.com");

        session.saveOrUpdate(customer);
        List<Customer> customerList2 = query.getResultList();
        assertEquals(1, customerList2.size());
    }

    @Test
    public void manyPacketSaveTest() {
        Query query = session.createNativeQuery("SELECT * FROM demo_db.customer");

        for (int i = 1; i <= 105; i++) {
            Customer customer = new Customer();
            customer.setFirstName("testName_" + i);
            customer.setLastName("test2LastName_" + i);
            customer.setEmail("testEmail_" + i + "@test.com");

            session.save(customer);
            if (i != 0  && i % 100 == 0) {
                session.flush();
                session.clear();
            }
            List<Customer> customerList = query.getResultList();
            System.out.println("Проход_" + i + ", Количество прочитанных = " + customerList.size());
        }
        tx.commit();
        List<Customer> customerList2 = query.getResultList();
        System.out.println("Проход_Последний, Количество прочитанных = " + customerList2.size());
        session.close();
    }

    @Test
    public void manyPacketSaveTest2() {
        Query query = session.createNativeQuery("SELECT * FROM demo_db.customer");

        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < 105; i++) {
            Customer customer = new Customer();
            customer.setFirstName("testName_" + i);
            customer.setLastName("test2LastName_" + i);
            customer.setEmail("testEmail_" + i + "@test.com");
            customerList.add(customer);
        }

        for (int i = 0; i < customerList.size(); i++) {
            session.save(customerList.get(i));
            if (i != 0  && i % 100 == 0) {
                session.flush();
                session.clear();
            }
            List<Customer> customerListPrint = query.getResultList();
            System.out.println("Проход_" + i + ", Количество прочитанных = " + customerListPrint.size());
        }
        tx.commit();
        List<Customer> customerListPrint2 = query.getResultList();
        System.out.println("Проход_Последний, Количество прочитанных = " + customerListPrint2.size());
        session.close();
    }

//    @After
//    public void after() {
//        session.close();
//        sessionFactory.close();
//    }
}
