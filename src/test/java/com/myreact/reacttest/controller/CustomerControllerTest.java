package com.myreact.reacttest.controller;

import com.myreact.reacttest.entity.Customer;
import com.myreact.reacttest.service.CustomerService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
    private CustomerService service;
    private CustomerController controller;

    @Before
    public void setUp() {
        service = mock(CustomerService.class);
        controller = new CustomerController(service);
    }

    @Test
    public void firstTest() {
        controller.saveCustomer(getCustomer());

        Model model = createModel();
        model.addAttribute("customers", getCustomers());
        String result = controller.listCustomers(model);
        assertEquals("index", result);
    }

    @Test
    public void listCustomersTrueTest() {
        String response = controller.listCustomers(createModel());
        assertEquals("index", response);
    }

    @Test
    public void listCustomersFalse1Test() {
//        Вызывать ошибку в контроллере если метод что-то возвращает:
        when(service.getCustomers()).thenThrow(new RuntimeException("Ошибка_"));
        String response = controller.listCustomers(any());
        assertEquals("error", response);
    }

    @Test
    public void listCustomersFalse2Test() {
//        Вызывать ошибку в контроллере если метод ничего не возвращает:
        doThrow(new RuntimeException()).doNothing().when(service).saveCustomer(any());
        String response = controller.listCustomers(any());
        assertEquals("error", response);
    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("firstSave_Test");
        customer.setLastName("lastSave_Test");
        customer.setEmail("email@gmail.com_Test");
        return customer;
    }

    private List<Customer> getCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("firstSave_Test");
        customer.setLastName("lastSave_Test");
        customer.setEmail("email@gmail.com_Test");
        //return new ArrayList<>(Arrays.asList(customer));
        return Lists.newArrayList(customer);
    }

    private Model createModel() {
        return new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return null;
            }

            @Override
            public Model addAttribute(Object attributeValue) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Object getAttribute(String attributeName) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
    }
}
