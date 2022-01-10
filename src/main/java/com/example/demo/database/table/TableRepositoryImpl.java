package com.example.demo.database.table;

import com.example.demo.domain.table.TableModel;
import com.example.demo.domain.table.TableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TableRepositoryImpl implements TableRepository {
    @Override
    public Optional<List<TableModel>> getAllAvailable() {
        return Optional.empty();
    }
}
