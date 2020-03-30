package com.yoke.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spittle {
    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spittle spittle = (Spittle) o;
        return Objects.equals(id, spittle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash
                (id, message, time, latitude, longitude);
    }
}
