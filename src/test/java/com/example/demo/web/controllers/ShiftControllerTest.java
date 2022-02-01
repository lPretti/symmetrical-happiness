package com.example.demo.web.controllers;

import com.example.demo.database.shift.ShiftEntity;
import com.example.demo.database.shift.ShiftJpaRepository;
import com.example.demo.web.dtos.ShiftDtoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShiftControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private ShiftJpaRepository jpaRepository;

    static final LocalDateTime date = LocalDateTime.now();

    @Test
    void shiftCreationWorksOk() throws Exception {
        Long ID = 1L;
        final ShiftEntity entityExpected = new ShiftEntity();
        entityExpected.setId(1L);
        entityExpected.setCreated_At(date);
        entityExpected.setInitialTime(16);

        final ShiftDtoRequest dtoRequest = new ShiftDtoRequest(Date.from(Instant.now()),2);
        when(jpaRepository.save(any(ShiftEntity.class))).thenReturn(entityExpected);
        mvc.perform(post("/admin/shift").param(String.valueOf(dtoRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"shiftId\":1L\"}]"));

    }


}