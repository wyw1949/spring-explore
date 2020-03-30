package com.yoke.repository.impl;

import com.yoke.model.Spitter;
import com.yoke.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    private static String INSERT = "insert into spitter(firstName, lastName, username, registerTime, password)" +
            "values(?, ?, ?, ?, ?)";


    @Override
    public void save(Spitter spitter) {
        jdbcOperations.update(INSERT, spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getUsername(),
                spitter.getRegisterTime(),
                spitter.getPassword());
    }

    @Override
    public Spitter findSpitterByUsername(final String username) {

        return jdbcOperations.query("SELECT id, username, password WHERE username = ?",
                rs -> {
                    Spitter spitter = new Spitter();
                    spitter.setId(rs.getLong("id"));
                    spitter.setUsername(rs.getString("username"));
                    spitter.setPassword(rs.getString("password"));
                    return spitter;
                }, username);
    }
}
