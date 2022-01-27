package com.example.demo.domain.shift;

import java.util.Date;
import java.util.Optional;

public interface ShiftRepository {
    Optional<ShiftModel> getByDate(Date date);
    ShiftModel update(ShiftModel model);
    ShiftModel create(ShiftModel model);
}
