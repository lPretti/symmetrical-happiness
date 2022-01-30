package com.example.demo.domain.reservation;

import com.example.demo.domain.customer.CustomerModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationModel {
    private Long id;
    private Date date;
    private Long shiftId;
    private int customerQuantity;
    private CustomerModel customer;
    private ReservationStatus status;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;
    private boolean deleted;

}
