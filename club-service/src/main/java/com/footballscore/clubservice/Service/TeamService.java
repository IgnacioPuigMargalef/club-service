package com.footballscore.clubservice.Service;

import com.footballscore.clubservice.Repository.Entity.TeamEntity;
import com.footballscore.clubservice.Repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamEntity getTeamById(final Integer id) {
        return teamRepository.getTeamById(id);
    }

}
