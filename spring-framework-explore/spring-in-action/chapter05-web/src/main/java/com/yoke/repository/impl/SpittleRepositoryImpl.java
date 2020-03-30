package com.yoke.repository.impl;

import com.yoke.constant.SimulateDB;
import com.yoke.model.Spittle;
import com.yoke.repository.SpittleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(Long max, Integer count) {
        List<Spittle> result = new ArrayList<>();
        for (Spittle spittle : SimulateDB.table_spittle){
            if (spittle.getId() < max && result.size() <= count){
                result.add(spittle);
            }
        }
        return result;
    }

    @Override
    public Spittle findOneById(Long id) {
        for (Spittle spittle : SimulateDB.table_spittle){
            if (spittle.getId() == id){
                return spittle;
            }
        }
        return null;
    }
}
