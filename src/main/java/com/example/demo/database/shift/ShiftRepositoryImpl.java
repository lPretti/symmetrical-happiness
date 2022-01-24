package com.example.demo.database.shift;

import com.example.demo.database.customer.CustomerEntity;
import com.example.demo.domain.customer.CustomerModel;
import com.example.demo.domain.shift.ShiftModel;
import com.example.demo.domain.shift.ShiftRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public class ShiftRepositoryImpl implements ShiftRepository {

    @Override
    public boolean getShiftByDate(Date date) {
        return false;
    }

    private ShiftModel toModel(ShiftEntity entity) {
        return new ShiftModel(entity.getId(),
                entity.getDate(),
                entity.getInitialTime(),
                entity.getAvailableTables(),
                entity.getCreated_At(),
                entity.getUpdated_At());
    }
    private ShiftEntity toEntity(ShiftModel model) {
        return new ShiftEntity(model.getId(),
                model.getDate(),
                model.getInitialTime(),
                model.getAvailableTables(),
                model.getCreated_At(),
                model.getUpdated_At());
    }
}
