package com.example.demo.database.customer;

import com.example.demo.domain.customer.CustomerModel;

public interface CustomerRepository {
    CustomerModel create(CustomerModel customer);

    CustomerModel getById();
}
