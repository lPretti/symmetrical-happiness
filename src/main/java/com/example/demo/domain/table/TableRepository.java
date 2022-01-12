package com.example.demo.domain.table;

import java.util.List;
import java.util.Optional;

public interface TableRepository {
    List<TableModel> getAllByTableStatus(int code);
    Optional<TableModel> getById(int id);
}
