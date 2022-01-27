package com.example.demo.database.reservation;

import com.example.demo.domain.reservation.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {
}
