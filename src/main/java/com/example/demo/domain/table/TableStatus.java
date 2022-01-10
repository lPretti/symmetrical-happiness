package com.example.demo.domain.table;

import lombok.Getter;

import java.util.stream.Stream;

public enum TableStatus {
    TAKEN(1),
    AVAILABLE(2),
    DISABLE(0);

    @Getter
    private final int id;

    TableStatus(int id) {
        this.id = id;
    }

    public static TableStatus of(int status) {
        return Stream.of(TableStatus.values())
                .filter(p -> p.getId() == status)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
