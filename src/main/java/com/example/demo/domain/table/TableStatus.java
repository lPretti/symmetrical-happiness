package com.example.demo.domain.table;

import lombok.Getter;

import java.util.stream.Stream;

public enum TableStatus {
    TAKEN,
    AVAILABLE,
    DISABLE;


    public static TableStatus getStatus(String status) {
        TableStatus result;
        switch (status) {
            case "TAKEN" :
                result =TableStatus.TAKEN;
                break;
            case "AVAILABLE" :
                result =TableStatus.AVAILABLE;
                break;
            case "DISABLE" :
                result =TableStatus.DISABLE;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
        return result;
    }
}
