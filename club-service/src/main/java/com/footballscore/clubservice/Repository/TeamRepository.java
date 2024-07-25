package com.footballscore.clubservice.Repository;

import ch.qos.logback.classic.Logger;
import com.footballscore.clubservice.Exception.NotFoundTeamException;
import com.footballscore.clubservice.Repository.Entity.TeamEntity;
import com.footballscore.clubservice.Repository.Mapper.TeamRowMapper;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TeamRepository {

    private final TeamRowMapper teamRowMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static final Logger LOGGER = (Logger)LoggerFactory.getLogger(TeamRepository.class);

    public TeamEntity getTeamById(final Integer id) {
        try {
            final MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("id", id);
            return jdbcTemplate.queryForObject(Queries.GET_TEAM_BY_ID, namedParameters, teamRowMapper);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.info("Team with id [{}] not found", id);
            throw new NotFoundTeamException();
        }
    }
}
