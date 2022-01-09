package com.example.demo.database.table;

import com.example.demo.database.table.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableJpaRepository extends JpaRepository<TableEntity,Integer> {
}
