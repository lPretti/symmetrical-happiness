package com.example.demo.database.table;

import com.example.demo.domain.table.TableModel;
import com.example.demo.domain.table.TableRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Repository
public class TableRepositoryImpl implements TableRepository {
    private TableJpaRepository repository;

    public TableRepositoryImpl(TableJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TableModel> getAllByTableStatus(int code) {
        return repository.getAllByTableStatus(code)
                .stream()
                .map(this::toModel)
                .collect(toList());
    }

    private TableModel toModel(TableEntity entity){
        return new TableModel(entity.getId(),
                entity.getStatus(),
                entity.getSits(),
                entity.isOutside());
    }

    private TableEntity toEntity(TableModel model){
        return new TableEntity(model.getId(),
                model.getStatus(),
                model.getStatus().getCode(),
                model.getSits(),
                model.isOutside());
    }
}
