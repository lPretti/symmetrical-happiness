package com.example.demo.domain.table;

import lombok.Getter;

import java.util.stream.Stream;

public enum TableStatus {
    TAKEN(100),
    AVAILABLE(200),
    DISABLE(300);

    @Getter
    private final int code;

    TableStatus(int code) {
        this.code = code;
    }
}
