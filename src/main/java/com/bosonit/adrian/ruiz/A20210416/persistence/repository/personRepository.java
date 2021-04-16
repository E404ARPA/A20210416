package com.bosonit.adrian.ruiz.A20210416.persistence.repository;

import com.bosonit.adrian.ruiz.A20210416.model.person.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personRepository extends JpaRepository<person, String> {
}
