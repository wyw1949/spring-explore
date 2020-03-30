package com.yoke.repository;

import com.yoke.model.Spitter;

public interface SpitterRepository {
    void save(Spitter spitter);

    Spitter findSpitterByUsername(String username);
}
