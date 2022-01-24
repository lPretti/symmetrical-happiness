package com.example.demo.database.shift;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @CollectionTable(name = "available_table_mapping")
    @MapKeyColumn(name = "table_id")
    @Column(name = "table_quantity")
    private Map<Integer, Integer> availableTables;

    @Column(name = "created_At")
    private LocalDateTime created_At;

    @Column(name = "updated_At")
    private LocalDateTime updated_At;
}
