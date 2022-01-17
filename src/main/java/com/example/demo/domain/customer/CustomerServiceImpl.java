package com.example.demo.domain.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl  implements CustomerServices{
    private CustomerRepository repository;


    @Override
    public CustomerModel create(CustomerModel customer) {
        return repository.create(customer);
    }

    @Override
    public CustomerModel getById(Long customerId) {
        return repository.getById(customerId);
    }
}
