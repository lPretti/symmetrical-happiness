package com.example.demo.web.controllers;


import com.example.demo.domain.shift.ShiftService;
import com.example.demo.web.dtos.ShiftDtoRequest;
import com.example.demo.web.dtos.ShiftDtoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ShiftController {
    private ShiftService shiftService;

    @PostMapping("admin/shift")
    public ResponseEntity<ShiftDtoResponse> create(ShiftDtoRequest dtoRequest) {
         return shiftService.create(dtoRequest.toModel());
    }
}
