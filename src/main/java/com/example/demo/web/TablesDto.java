package com.example.demo.web;


import com.example.demo.domain.table.TableModel;
import com.example.demo.domain.table.TableStatus;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TablesDto {
    private int id;
    private TableStatus status;
    private int sits;
    private boolean isOutside;

    public TablesDto toDto(TableModel model){
        return null;
    }
}
