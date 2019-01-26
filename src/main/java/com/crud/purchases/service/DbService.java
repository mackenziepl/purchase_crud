package com.crud.purchases.service;

import com.crud.purchases.domain.Thing;
import com.crud.purchases.domain.ThingDto;
import com.crud.purchases.repository.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    ThingRepository repository;

    public List<Thing> getAllThings() {
        return repository.findAll();
    }

    public Optional<Thing> getThing(final Long id) {
        return repository.findById(id);
    }

    public void deleteThing(final Long id) {
        repository.delete(id);
    }

    public Thing saveThing(final Thing thing) {
        return repository.save(thing);
    }
}
