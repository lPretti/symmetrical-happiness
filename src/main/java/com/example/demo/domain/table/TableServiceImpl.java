package com.example.demo.domain.table;

import com.example.demo.domain.DomainException;
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
        return repository.getAllByTableStatusCode(TableStatus.AVAILABLE.getCode());
    }

    @Override
    public TableModel getById(int tableId) {
        return repository.getById(tableId).orElseThrow(()->new DomainException());
    }

    @Override
    public TableModel create(TableModel model) {
        model.setStatus(TableStatus.AVAILABLE);
        return repository.create(model);
    }
}
