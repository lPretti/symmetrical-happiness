package com.example.demo.domain.shift;

import com.example.demo.domain.customer.CustomerModel;

import java.util.Date;

public interface ShiftService {
    boolean checkAvailableTables(int seatingNumber, Date date);
    int bookTable(int seatingNumber, Date date, CustomerModel customer);
    ShiftModel create(ShiftModel toModel);
}
