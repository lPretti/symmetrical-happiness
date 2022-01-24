package com.example.demo.domain.shift;

import java.sql.Date;

public interface ShiftRepository {
    boolean getShiftByDate(Date date);
}
