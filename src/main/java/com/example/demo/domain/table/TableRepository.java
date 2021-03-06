package com.example.demo.domain.table;

import java.util.List;
import java.util.Optional;

public interface TableRepository {
    List<TableModel> getAllByTableStatus(String status);

    Optional<TableModel> getById(int id);

    TableModel create(TableModel model);
}
