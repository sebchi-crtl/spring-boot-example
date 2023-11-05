package com.ethnocopia.controller;


import com.ethnocopia.dto.GreetResponse;
import com.ethnocopia.dto.NewCustomerRequest;
import com.ethnocopia.entity.Customer;
import com.ethnocopia.entity.Person;
import com.ethnocopia.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse greetResponse = new GreetResponse("hello", List.of("Java", "Golang", "JavaScript"), new Person("Alex", 28, 30_000));
        return greetResponse;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }


    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {


        customerService.addCustomer(request);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long id, @RequestBody NewCustomerRequest request) {


        customerService.updateCustomer(id, request);
    }
}
