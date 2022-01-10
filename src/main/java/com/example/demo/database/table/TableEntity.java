package com.example.demo.database.table;

import com.example.demo.domain.table.TableStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tables")
public class TableEntity implements Serializable {
    @Id
    @Column(name = "idTable")
    private int id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @Basic
    private int statusValue;

    @Column(name = "sits")
    private int sits;

    @Column(name = "outside")
    private boolean isOutside;

}
