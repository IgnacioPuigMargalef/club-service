package com.footballscore.clubservice.Controller;

import com.footballscore.clubservice.Repository.Entity.PlayerEntity;
import com.footballscore.clubservice.Service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/player")
@AllArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/list/{teamId}")
    public List<PlayerEntity> getPlayers(@PathVariable int teamId) {
        return playerService.getPlayersByTeamId(teamId);
    }
}
