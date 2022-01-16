package com.example.demo.web;

import com.example.demo.domain.table.TableModel;
import com.example.demo.domain.table.TableService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class TableController {

    private TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

    @GetMapping("/tables/all")
    public ResponseEntity<List<TablesDtoResponse>> getAllAvailable(){
        return ResponseEntity.ok(
                service.getAllAvailable()
                .stream()
                .map(this::toDto)
                .collect(toList())
        );
    }

    @GetMapping("/tables/{tableId}")
    public ResponseEntity<?> getTableById(@PathVariable("tableId")int tableId){
        return  ResponseEntity.ok(service.getById(tableId));
    }

    @PostMapping("/tables")
    public ResponseEntity<?> create(@RequestBody TablesDtoRequest tableDto){
        return  ResponseEntity.ok(service.create(toModel(tableDto)));
    }



    private TablesDtoResponse toDto(TableModel model){
        return new TablesDtoResponse(
                model.getId(),
                model.getStatus().name(),
                model.getSits(),
                model.isOutside()
        );
    }

    private TableModel toModel(TablesDtoRequest dtoRequest){
        final TableModel model = new TableModel();
        model.setSits(dtoRequest.getSits());
        model.setOutside(dtoRequest.isOutside());
        return model;
    }
}

@Getter
@Setter
@Builder
@AllArgsConstructor
class TablesDtoResponse {
    private int id;
    private String status;
    private int sits;
    private boolean isOutside;

}
@Getter
@Setter
@Builder
@AllArgsConstructor
class TablesDtoRequest {
    private int sits;
    private boolean isOutside;
}