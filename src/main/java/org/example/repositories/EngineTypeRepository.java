package org.example.repositories;

import org.example.dbrecords.EngineTypeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EngineTypeRepository extends JpaRepository<EngineTypeRecord, Long> {
    Collection<EngineTypeRecord> findByTypeName(String typeName);
}
