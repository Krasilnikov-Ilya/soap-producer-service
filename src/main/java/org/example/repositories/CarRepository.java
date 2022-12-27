package org.example.repositories;

import org.example.dbrecords.CarRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarRecord, Long> {}
