package com.example.demo.database.shift;

import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;

public interface ShiftJpaRepository extends JpaRepository<ShiftEntity, Long> {
    ShiftEntity getShiftByDate(Date date);
}
