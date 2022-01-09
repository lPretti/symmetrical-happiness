package com.example.demo.domain.table;

import java.util.List;

public class TableServiceImpl implements TableService{
    private TableRepository repository;

    public TableServiceImpl(TableRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TableModel> getAllAvailable() {
        return repository.getAllAvailable().get();
    }

    @Override
    public TableModel getById(int tableId) {
        return null;
    }
}
