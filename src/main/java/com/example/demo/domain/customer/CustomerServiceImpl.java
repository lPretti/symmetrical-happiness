package com.example.demo.domain.customer;

import com.example.demo.database.customer.CustomerRepository;
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
        return repository.getById();
    }
}
