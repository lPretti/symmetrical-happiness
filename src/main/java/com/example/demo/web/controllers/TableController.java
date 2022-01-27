package com.example.demo.web.controllers;

import com.example.demo.domain.table.TableService;
import com.example.demo.web.dtos.TableDtoRequest;
import com.example.demo.web.dtos.TableDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.example.demo.web.dtos.TableDtoRequest.toModel;
import static com.example.demo.web.dtos.TableDtoResponse.toDto;
import static java.util.stream.Collectors.toList;

@Controller
public class TableController {

    private TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

    @GetMapping("/tables/all")
    public ResponseEntity<List<TableDtoResponse>> getAllAvailable() {
        return ResponseEntity.ok(
                service.getAllAvailable()
                        .stream()
                        .map(t->toDto(t))
                        .collect(toList())
        );
    }

    @GetMapping("tables/{tableId}")
    public ResponseEntity<?> getTableById(@PathVariable("tableId") int tableId) {
        return ResponseEntity.ok(service.getById(tableId));
    }

    @PostMapping("admin/tables")
    public ResponseEntity<?> create(@RequestBody TableDtoRequest tableDto) {
        return ResponseEntity.ok(service.create(toModel(tableDto)));
    }
}



