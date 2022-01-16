package com.example.demo.web;

import com.example.demo.database.table.TableJpaRepository;
import com.example.demo.domain.table.TableModel;
import com.example.demo.domain.table.TableStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TableControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    TableController controller;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TableJpaRepository jpaRepository;

    private static final String GET_ALL_PATH = "/tables/all";
    private static final String GET_BY_ID = "/tables";

    private static List<TableModel> tables = new ArrayList<>();

    @BeforeEach
    public void beforeEach(){
        TableModel.TableModelBuilder builder = TableModel.builder();
        builder.sits(5)       ;
        builder.isOutside(false);

        tables.add(builder.id(1).status(TableStatus.AVAILABLE).build());
        tables.add(builder.id(2).status(TableStatus.AVAILABLE).build());
    }

    @AfterEach
    void clearTables(){
        tables.clear();
    }

    @Test
    void getAllAvailable() throws Exception {
    //when(jpaRepository.getAllByStatusValue(TableStatus.AVAILABLE));

    final MvcResult result = mvc.perform(get(GET_ALL_PATH))
            .andDo(print())
            .andExpect(status().is(HttpStatus.OK.value()))
            .andReturn();

    //final TablesDtoResponse tablesDto = objectMapper.readValue(result.getResponse().getContentAsString(), TablesDtoResponse.class);


    }

    @Test
    void getTableById() {
    }


}