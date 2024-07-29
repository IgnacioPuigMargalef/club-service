package com.footballscore.clubservice.Service;

import com.footballscore.clubservice.Repository.Entity.PlayerEntity;
import com.footballscore.clubservice.Repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<PlayerEntity> getPlayersByTeamId(Integer teamId) {
        return playerRepository.getPlayersByTeamId(teamId);
    }

}
