package com.example.demo.domain.table;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableModel {
    private int id;
    private TableStatus status;
    private int sits;
    private boolean isOutside;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
