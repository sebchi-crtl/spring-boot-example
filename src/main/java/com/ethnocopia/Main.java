package com.ethnocopia;
import java.util.List;
import java.util.Optional;

import com.ethnocopia.dao.CustomerRepository;
import com.ethnocopia.dto.NewCustomerRequest;
import com.ethnocopia.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Main {
    public static  void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
