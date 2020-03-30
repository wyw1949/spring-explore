package com.yoke.repository;

import com.yoke.model.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(Long max, Integer count);

    Spittle findOneById(Long id);
}
