package com.example.demo.web;

import com.example.demo.domain.table.TableModel;
import com.example.demo.domain.table.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TableController {

    private TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

    @GetMapping("/tables/all")
    public ResponseEntity<List<TableModel>> getAllAvailable(){
        return ResponseEntity.ok(service.getAllAvailable());
    }

    @GetMapping("/tables")
    public ResponseEntity<TableModel> getTableById(@PathVariable("tableId")int tableId){
        return  ResponseEntity.ok(service.getById(tableId));
    }
}
