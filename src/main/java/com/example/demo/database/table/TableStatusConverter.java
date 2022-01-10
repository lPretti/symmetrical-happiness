package com.example.demo.database.table;

import com.example.demo.domain.table.TableStatus;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class TableStatusConverter implements AttributeConverter<TableStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TableStatus status) {
        if (status == null){
            return null;
        }
        return status.getCode();
    }

    @Override
    public TableStatus convertToEntityAttribute(Integer code) {
        if (code == null){
            return null;
        }
        return Stream.of(TableStatus.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
