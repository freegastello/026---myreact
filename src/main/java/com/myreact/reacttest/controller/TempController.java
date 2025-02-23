package com.myreact.reacttest.controller;

import com.google.gson.Gson;
import com.myreact.reacttest.dto.GsonRequestDTO;
import com.myreact.reacttest.entity.Customer;
import com.myreact.reacttest.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TempController {
    private static final Logger log = LoggerFactory.getLogger(TempController.class);

    @Autowired
    private CustomerService customerService;

//    @GetMapping("/")
//    public String listCustomers(Model model) {
//        List<Customer> customerList = customerService.getCustomers();
//
//        Customer customer = new Customer();
//        customer.setFirstName("firstSave");
//        customer.setLastName("lastSave");
//        customer.setEmail("email@gmail.com");
//        customerService.saveCustomer(customer);
//
//        model.addAttribute("customers", customerList);
//        return "index";
//    }

//    // 1 GET Первый вариант
//    @GetMapping("/objtestget")
//    public String listCustomers(
//            String id_product,
//            String qty_product
//    ) {
//        log.info("Сработал GET контроллер. id_product = " + id_product + ", qty_product = " + qty_product);
//        List<Customer> customerList = customerService.getCustomers();
//        return "index";
//    }

    // 2 GET Второй вариант
    @GetMapping("/objtestget")
    public String listCustomers(GsonRequestDTO dto) {
        log.info("Сработал GET контроллер. id_product = " + dto.getId_product() + ", qty_product = " + dto.getQty_product());
        List<Customer> customerList = customerService.getCustomers();
        return "OK GET";
    }

    // 2 POST
    @PostMapping("/objtestpost")
    public String listCustomersPOST(GsonRequestDTO dto) {
        log.info("Сработал POST контроллер. Переменная = " + dto);
        return "OK POST";
    }

    // 3 POST - JSON
    @PostMapping("/objtestjson")
    @ResponseBody
    public String listCustomersJSON(@RequestBody String str) {
        log.info("Сработал JSON контроллер. Переменная = " + str);

//        GsonJsonParser g = new GsonJsonParser();
        Gson gson = new Gson();
        GsonRequestDTO dto = gson.fromJson(str, GsonRequestDTO.class);

        log.info("Gson GsonRequestDTO = " + dto);

        return "OK JSON";
    }


//    @GetMapping("/showForm")
//    public String showFormForAdd(Model theModel) {
//        Customer theCustomer = new Customer();
//        theModel.addAttribute("customer", theCustomer);
//        return "customer-form";
//    }
//
//    @PostMapping("/saveCustomer")
//    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
//        customerService.saveCustomer(theCustomer);
//        return "redirect:/customer/list";
//    }
//
//    @GetMapping("/updateForm")
//    public String showFormForUpdate(
//            @RequestParam("customerId") int theId,
//            Model theModel
//    ) {
//        Customer theCustomer = customerService.getCustomer(theId);
//        theModel.addAttribute("customer", theCustomer);
//        return "customer-form";
//    }
//
//    @GetMapping("/delete")
//    public String deleteCustomer(@RequestParam("customerId") int theId) {
//        customerService.deleteCustomer(theId);
//        return "redirect:/customer/list";
//    }
}


//        Customer customer = new Customer();
//        customer.setFirstName("firstSave");
//        customer.setLastName("lastSave");
//        customer.setEmail("email@gmail.com");
//        customerService.saveCustomer(customer);

