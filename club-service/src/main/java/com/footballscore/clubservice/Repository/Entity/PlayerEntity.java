package com.footballscore.clubservice.Repository.Entity;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PlayerEntity(
        Integer id,
        String name,
        String surname,
        LocalDate birth_date,
        LocalDate birth_country,
        byte[] photo,
        Integer team_id
) {
}
