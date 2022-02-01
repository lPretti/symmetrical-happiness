package com.example.demo.domain;

import lombok.Getter;

@Getter
public enum TableKey {
    DOS(2),
    CUATRO(4),
    SEIS(6);

    private int number;

    TableKey(int i) {
    }
}
