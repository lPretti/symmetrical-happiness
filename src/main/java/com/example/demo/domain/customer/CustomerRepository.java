package com.example.demo.domain.customer;

public interface CustomerRepository {
    CustomerModel create(CustomerModel customer);

    CustomerModel getById(Long customerId);
}
