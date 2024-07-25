package com.footballscore.clubservice.Controller;

import com.footballscore.clubservice.Repository.Entity.TeamEntity;
import com.footballscore.clubservice.Service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping(value = "/{id}")
    public TeamEntity getTeamById(@PathVariable final Integer id) {
        return teamService.getTeamById(id);
    }

}
