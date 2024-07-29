package com.footballscore.clubservice.Repository.Mapper;

import com.footballscore.clubservice.Repository.Entity.PlayerEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlayerRowMapper implements RowMapper<PlayerEntity> {


    @Override
    public PlayerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PlayerEntity.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .photo(rs.getBytes("photo"))
                .birth_country(rs.getString("birth_country"))
                .birth_date(rs.getTimestamp("birth_date").toLocalDateTime().toLocalDate())
                .team_id(rs.getInt("team_id"))
                .build();
    }
}
