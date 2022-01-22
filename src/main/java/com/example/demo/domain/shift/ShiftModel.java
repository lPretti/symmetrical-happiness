package com.example.demo.domain.shift;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Data
public class ShiftModel {
    protected static final  Integer TABLE_FOR_2 = 2;
    protected static final  Integer TABLE_FOR_4 = 4;
    protected static final  Integer TABLE_FOR_6 = 6;
    protected static final  Integer TABLE_FOR_8 = 8;
    
    private Long id;
    private Date date;
    private Time initialTime;
    private HashMap <Integer, Integer> availableTables;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

    public ShiftModel() {
        this.availableTables = new HashMap<Integer,Integer>();
        availableTables.put(TABLE_FOR_2,0);
        availableTables.put(TABLE_FOR_4,0);
        availableTables.put(TABLE_FOR_6,0);
        availableTables.put(TABLE_FOR_8,0);
    }
}
