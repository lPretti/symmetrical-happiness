package com.example.demo.web.dto;

import com.example.demo.domain.table.TableModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TableDtoResponse {
        private int id;
        private String status;
        private int sits;
        private boolean isOutside;

    public static TableDtoResponse toDto(TableModel model){
        return new TableDtoResponse(
                model.getId(),
                model.getStatus().name(),
                model.getSits(),
                model.isOutside()
        );
    }

}
