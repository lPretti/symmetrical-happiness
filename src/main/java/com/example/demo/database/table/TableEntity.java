package com.example.demo.database.table;

import com.example.demo.domain.table.TableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "tables")
public class TableEntity implements Serializable {
    @Id
    @Column(name = "idTable")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tableStatus")
    private String tableStatus;

    @Column(name = "sits")
    private int sits;

    @Column(name = "outside")
    private boolean isOutside;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
}
