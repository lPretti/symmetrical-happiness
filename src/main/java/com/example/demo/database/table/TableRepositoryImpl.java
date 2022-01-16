package com.example.demo.database.table;

import com.example.demo.domain.table.TableModel;
import com.example.demo.domain.table.TableRepository;

import com.example.demo.domain.table.TableStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
    public List<TableModel> getAllByTableStatus(String status) {
        return repository.getAllByTableStatus(status)
                .stream()
                .map(this::toModel)
                .collect(toList());
    }

    @Override
    public Optional<TableModel> getById(int id) {
        final Optional<TableEntity> entity = repository.findById(id);
        return (entity.isPresent()) ? Optional.of(toModel(entity.get())) : Optional.empty();
    }

    @Override
    public TableModel create(TableModel model) {
        return toModel(repository.save(toEntity(model)));
    }

    private TableModel toModel(TableEntity entity){
        return new TableModel(entity.getId(),
                TableStatus.getStatus(entity.getTableStatus()),
                entity.getSits(),
                entity.isOutside(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());
    }

    private TableEntity toEntity(TableModel model){
        TableEntity entity = new TableEntity();
            entity.setId(model.getId());
            entity.setTableStatus(model.getStatus().toString());
            entity.setSits(model.getSits());
            entity.setOutside(model.isOutside());
            entity.setCreatedAt(LocalDateTime.now());
            entity.setUpdatedAt(entity.getCreatedAt());
        return entity;
    }
}
