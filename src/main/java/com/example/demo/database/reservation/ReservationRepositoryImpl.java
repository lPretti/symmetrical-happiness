package com.example.demo.database.reservation;

import com.example.demo.domain.reservation.ReservationModel;
import com.example.demo.domain.reservation.ReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    @Override
    public ReservationModel create(ReservationModel reservation) {
        return null;
    }

    private ReservationModel toModel(ReservationEntity entity) {
        return new ReservationModel( );
    }
    private ReservationEntity toEntity(ReservationModel model) {
        return new ReservationEntity();
    }
}
