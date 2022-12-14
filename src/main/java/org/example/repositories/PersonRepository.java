package org.example.repositories;

import org.example.dbrecords.PersonRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonRecord, Long> {}
