package com.example.demo.domain.shift;

import com.example.demo.domain.TableKey;
import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ShiftModel {

    private Long id;
    private Date date;
    private int initialTime;
    private Map<Integer, Integer> availableTables;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

    public ShiftModel() {
        this.availableTables = new HashMap<Integer,Integer>();
        availableTables.put(TableKey.DOS.ordinal(), 0);
        availableTables.put(TableKey.CUATRO.ordinal(), 0);
        availableTables.put(TableKey.SEIS.ordinal(), 0);
    }
}
