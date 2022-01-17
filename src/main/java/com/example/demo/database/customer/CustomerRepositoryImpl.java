package com.example.demo.database.customer;

import com.example.demo.domain.customer.CustomerModel;
import com.example.demo.domain.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private CustomerJpaRepository repository;
    @Override
    public CustomerModel create(CustomerModel customer) {
        return toModel(repository.save(toEntity(customer)));
    }

    @Override
    public CustomerModel getById(Long customerId) {
        return toModel(repository.getById(customerId));
    }

    private CustomerModel toModel(CustomerEntity entity) {
        return new CustomerModel(entity.getId(),
                entity.getMail(),
                entity.getPhone(),
                entity.getName(),
                entity.getCreated_At(),
                entity.getUpdated_At());
    }
    private CustomerEntity toEntity(CustomerModel model) {
        return new CustomerEntity(model.getId(),
                model.getMail(),
                model.getPhone(),
                model.getName(),
                model.getCreated_At(),
                model.getUpdated_At());
    }
}
