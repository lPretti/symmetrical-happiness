package com.example.demo.domain.table;

import com.example.demo.database.table.TableEntity;
import lombok.*;

import javax.swing.text.html.parser.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableModel {
    private int id;
    private TableStatus status;
    private int sits;
    private boolean isOutside;
}
