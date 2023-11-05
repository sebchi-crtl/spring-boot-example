package com.ethnocopia.service;

import com.ethnocopia.dao.CustomerRepository;
import com.ethnocopia.dto.NewCustomerRequest;
import com.ethnocopia.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    public void addCustomer( NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());

        customerRepository.save(customer);
    }

    public void deleteCustomer( Long id) {
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Long id, NewCustomerRequest request) {
        Optional<Customer> customerWrapper = customerRepository.findById(id);
        if (!customerWrapper.isPresent())
            return;

        Customer customer = customerWrapper.get();
        customer.setName(request.name());
        customer.setAge(request.age());
        customer.setEmail(request.email());

        customerRepository.save(customer);
    }
}
