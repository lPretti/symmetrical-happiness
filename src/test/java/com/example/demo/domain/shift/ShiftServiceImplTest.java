package com.example.demo.domain.shift;

import com.example.demo.database.customer.CustomerEntity;
import com.example.demo.database.shift.ShiftEntity;
import com.example.demo.database.shift.ShiftJpaRepository;
import com.example.demo.domain.customer.CustomerModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class ShiftServiceImplTest {

    @Mock
    ShiftJpaRepository shiftRepository;

    @InjectMocks
    ShiftServiceImpl shiftService;

    final static private Date RESERVATION_DATE = new Date("12/02/2002");
    final static private int SHIFT_ID = 1;
    final static private int CUSTOMER_QUANTITY = 2;
    final static private int DEFAULT_AVAILABLE_NUM =1;

    static private List<ShiftModel> shifts = new ArrayList();


    @BeforeEach
    public  void setUp(){
        initMock();
        initMockShiftTables();
    }

    @AfterEach
    public void clearShiftList(){
        shifts.clear();
    }

    private void initMock(){
        MockitoAnnotations.openMocks(this);
    }

    private void initMockShiftTables(){
        Map<Integer,Integer> availability = new HashMap<>();
        availability.put(2,DEFAULT_AVAILABLE_NUM);
        availability.put(4,DEFAULT_AVAILABLE_NUM);
        availability.put(6,DEFAULT_AVAILABLE_NUM);

        final  ShiftModel mockShift = ShiftModel.builder()
                .availableTables(availability)
                .date(RESERVATION_DATE)
                .id(Long.valueOf(SHIFT_ID))
                .build();

        shifts.add(mockShift);
    }

    @Test
    void checkAvailableTablesWorksOk() {

        final ShiftEntity entity = ShiftEntity.builder()
                .date(RESERVATION_DATE)
                .id(Long.valueOf(SHIFT_ID))
                .build();
        when(shiftRepository.getShiftByDate(RESERVATION_DATE)).thenReturn(Optional.of(entity));
        final boolean availabilityResult = shiftService.checkAvailableTables(CUSTOMER_QUANTITY, RESERVATION_DATE);

        assertTrue(availabilityResult);
    }



}