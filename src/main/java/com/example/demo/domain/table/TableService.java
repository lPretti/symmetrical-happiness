package com.example.demo.domain.table;

import java.util.List;

public interface TableService {
    List<TableModel> getAllAvailable();
    TableModel getById(int tableId);
}
