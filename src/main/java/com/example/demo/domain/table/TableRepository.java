package com.example.demo.domain.table;

import java.util.List;
import java.util.Optional;

public interface TableRepository {
    Optional<List<TableModel>> getAllAvailable();
}
