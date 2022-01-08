package com.example.demo.database.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tables")
public class TableEntity implements Serializable {
    @Id
    @Column(name = "idTable")
    private int id;
    @Column(name = "status")
    private int status;
    @Column(name = "sits")
    private int sits;
    @Column(name = "outside")
    private boolean isOutside;
}
