package com.example.demo.database.shift;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.Optional;

public interface ShiftJpaRepository extends JpaRepository<ShiftEntity, Long> {
    Optional<ShiftEntity> getShiftByDate(Date date);
}
