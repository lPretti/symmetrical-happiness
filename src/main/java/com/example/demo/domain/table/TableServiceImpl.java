package com.example.demo.domain.table;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
