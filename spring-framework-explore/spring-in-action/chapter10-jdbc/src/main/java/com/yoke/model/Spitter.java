package com.yoke.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spitter {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Date registerTime;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spitter spitter = (Spitter) o;
        return Objects.equals(id, spitter.id) &&
                Objects.equals(username, spitter.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    public interface SaveSpitter{}
}
