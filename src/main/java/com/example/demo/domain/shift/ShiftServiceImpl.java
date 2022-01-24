package com.example.demo.domain.shift;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShiftServiceImpl implements ShiftService {
    private ShiftRepository repository;


    @Override
    public boolean hasAvailableTablesForQuantity(int customersquantity) {
        return repository.hasAvailableTablesForQuantity(customersquantity);
    }
}
