package com.example.demo.database.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity,Long> {
}
