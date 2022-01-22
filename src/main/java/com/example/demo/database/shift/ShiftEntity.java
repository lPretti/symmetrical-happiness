package com.example.demo.database.shift;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Data
@Entity
@Table(name = "shift")
public class ShiftEntity {
    @Id
    @Column(name = "idShift")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "initialTime")
    private Time initialTime;

    @ElementCollection
    @CollectionTable(name = "available_table_mapping",
    joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "item_name")
    @Column(name = "price")
    private HashMap<Integer, Integer> availableTables;

    @Column(name = "created_At")
    private LocalDateTime created_At;

    @Column(name = "updated_At")
    private LocalDateTime updated_At;
}
