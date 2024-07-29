package com.footballscore.clubservice.Repository;

import ch.qos.logback.classic.Logger;
import com.footballscore.clubservice.Exception.NotFoundPlayersException;
import com.footballscore.clubservice.Repository.Entity.PlayerEntity;
import com.footballscore.clubservice.Repository.Mapper.PlayerRowMapper;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PlayerRepository {

    private final PlayerRowMapper playerRowMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final static Logger LOGGER = (Logger) LoggerFactory.getLogger(PlayerRepository.class);

    public List<PlayerEntity> getPlayersByTeamId(Integer teamId) {
        LOGGER.info("PlayerRepository - Begin getPlayersByTeamId, searching by [{}]", teamId);
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("team_id", teamId);
        List<PlayerEntity> players = jdbcTemplate.query(Queries.GET_PLAYERS_BY_TEAM_ID, params, playerRowMapper);

        if (players.isEmpty()) {
            LOGGER.warn("No record found for team id {}", teamId);
            throw new NotFoundPlayersException();
        }

        return players;
    }

}
