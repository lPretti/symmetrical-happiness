package com.example.demo.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Timer;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShiftDtoResponse {

    private Long shiftId;
    private Date date;
    private Timer initialTime;
}
