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
    public List<TableModel> getAllByTableStatusCode(int code) {
        return repository.getAllByStatusValue(code)
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
                entity.getStatus(),
                entity.getSits(),
                entity.isOutside());
    }

    private TableEntity toEntity(TableModel model){
        TableEntity entity = new TableEntity();
            entity.setId(model.getId());
            entity.setStatus(model.getStatus());
            entity.setSits(model.getSits());
            entity.setOutside(model.isOutside());
        return entity;
    }
}
