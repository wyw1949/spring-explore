package com.yoke.repository.impl;

import com.yoke.constant.SimulateDB;
import com.yoke.model.Spitter;
import com.yoke.repository.SpitterRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public void save(Spitter spitter) {
        SimulateDB.table_spitter.add(spitter);
    }

    @Override
    public Spitter findSpitterByUsername(final String username) {
        return SimulateDB.table_spitter.stream().filter(o -> Objects.equals(username, o.getUsername())).findAny().orElse(null);
    }
}
