package com.example.demo.domain.customer;

public interface CustomerServices {
    CustomerModel create(CustomerModel customer);
    CustomerModel getById(Long customerId);
}
