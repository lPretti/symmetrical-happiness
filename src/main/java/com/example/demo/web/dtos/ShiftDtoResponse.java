package com.example.demo.web.dtos;

import com.example.demo.domain.shift.ShiftModel;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShiftDtoResponse {

    private Long shiftId;
  //  private Date date;
  //  private int timeRef;

    public static ShiftDtoResponse toDto(ShiftModel model) {
        final ShiftDtoResponse dto = new ShiftDtoResponse(
                model.getId());
  //              model.getDate(),
  //              model.getInitialTime());
        return dto;
    }
}
