package com.example.demo.domain.shift;

import org.springframework.stereotype.Service;

public interface ShiftService {
    boolean hasAvailableTablesForQuantity(int customersquantity);

}
