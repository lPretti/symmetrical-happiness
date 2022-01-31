package com.example.demo.database.shift;

import com.example.demo.domain.shift.ShiftModel;
import com.example.demo.domain.shift.ShiftRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class ShiftRepositoryImpl implements ShiftRepository {
    private ShiftJpaRepository jpaRepository;

    @Override
    public Optional<ShiftModel> getByDate(Date date) {
        final Optional<ShiftEntity> shiftByDate = jpaRepository.getShiftByDate(date);
        return  shiftByDate.isPresent() ? Optional.of(toModel(shiftByDate.get())) : Optional.empty();
    }

    @Override
    public ShiftModel update(ShiftModel model) {
        return toModel(jpaRepository.save(toEntity(model)));
    }

    @Override
    public  ShiftModel create(ShiftModel model) {
        final LocalDateTime dateTime = LocalDateTime.now();

        ShiftEntity entity = new ShiftEntity();
        entity.setAvailableTables(model.getAvailableTables());
        entity.setDate(model.getDate());
        entity.setInitialTime(model.getInitialTime());
        entity.setCreated_At(dateTime);
        entity.setUpdated_At(dateTime);

        return toModel(jpaRepository.save(entity));
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
