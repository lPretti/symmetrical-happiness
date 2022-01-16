package com.example.demo.database.table;

import com.example.demo.database.table.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableJpaRepository extends JpaRepository<TableEntity,Integer> {
    List<TableEntity> getAllByTableStatus(String status);
}
