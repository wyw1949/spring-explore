package com.yoke.repository.impl;

import com.yoke.model.Spittle;
import com.yoke.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Spittle> findSpittles(Long max, Integer count) {
        List<Spittle> result = new ArrayList<>();

        return result;
    }

    @Override
    public Spittle findOneById(Long id) {

        return null;
    }
}
