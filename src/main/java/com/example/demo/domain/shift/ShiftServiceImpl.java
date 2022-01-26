package com.example.demo.domain.shift;

import com.example.demo.domain.DomainException;
import com.example.demo.domain.customer.CustomerModel;
import com.example.demo.domain.reservation.ReservationServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private ShiftRepository repository;

    private ReservationServices reservationServices;

    public boolean checkAvailableTables(int seatingNumber, Date date) {
            boolean result = false;

            final Optional<ShiftModel> shiftByDate = repository.getShiftByDate(date);
            if (shiftByDate.isPresent()) {
                final Map<Integer, Integer> availableTables = shiftByDate.get().getAvailableTables();
                final Integer tablesAvailable = availableTables.get(getTableKeyValue(seatingNumber));

                if (tablesAvailable > 0) {
                    result = true;
                }
            } else {
                throw  new DomainException("shift domain fails : date don´t exists");
            }

            return result;
    }

    @Override
    public int bookTable(int seatingNumber, Date date, CustomerModel customer) {
        int result = 0;

        if (checkAvailableTables(seatingNumber,date)) {
            final ShiftModel shiftToUpdated = removeTableReserved( repository.getByDate(date).get(), seatingNumber);
            final ShiftModel updated = repository.update(shiftToUpdated);
            result = Math.toIntExact(updated.getId());
        } else {
            throw new DomainException("Shift services fail : can't book a table ");
        }
        return result;
    }

    protected  ShiftModel removeTableReserved( ShiftModel model, int seatingNumber) {
        final Integer tables = model.getAvailableTables().get(getTableKeyValue(seatingNumber));
        model.getAvailableTables().replace(2, tables - 1);
        return model;
    }

    protected int getTableKeyValue(int customerQuantity) {
        int tableKey = 0;

        if(customerQuantity > 0 && customerQuantity <= 2) {
            return 2;
        } else if (customerQuantity > 2 && customerQuantity <= 4) {
            return 4;
        } else if (customerQuantity > 4 && customerQuantity <= 6) {
            return 6;
        } else if (customerQuantity > 6 ) {
            return 8;
        }

        return tableKey;
    }
}
