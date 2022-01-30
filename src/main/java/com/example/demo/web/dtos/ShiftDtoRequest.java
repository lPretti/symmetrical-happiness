package com.example.demo.web.dtos;

import com.example.demo.domain.shift.ShiftModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShiftDtoRequest {
    private Date date;
    private int timeRef;

    public ShiftModel toModel() {
        final ShiftModel model = new ShiftModel();
        model.setDate(this.date);
        model.setInitialTime(this.timeRef);
        return model;
    }
}
