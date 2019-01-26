package com.crud.purchases.repository;

import com.crud.purchases.domain.Thing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ThingRepository extends CrudRepository<Thing, Long> {

    List<Thing> findAll();

    Optional<Thing> findById(Long id);
}
