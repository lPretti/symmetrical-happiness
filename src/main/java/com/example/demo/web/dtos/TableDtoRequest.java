package com.example.demo.web.dtos;

import com.example.demo.domain.table.TableModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TableDtoRequest {
    private int sits;
    private boolean isOutside;

    public static TableModel toModel(TableDtoRequest dtoRequest){
        final TableModel model = new TableModel();
        model.setSits(dtoRequest.getSits());
        model.setOutside(dtoRequest.isOutside());
        return model;
    }
}
