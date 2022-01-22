package com.example.demo.database.shift;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftJpaRepository extends JpaRepository<ShiftEntity, Long> {
}
