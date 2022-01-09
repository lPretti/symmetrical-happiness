package com.example.demo.domain.table;

import lombok.Getter;

public enum TableStatus {
    TAKEN(1),
    AVAILABLE(2),
    DISABLE(0);

    @Getter
    private final int id;

    TableStatus(int id) {
        this.id = id;
    }
}
