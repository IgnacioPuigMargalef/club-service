package com.footballscore.clubservice.Repository;

public class Queries {

    /** Team queries */
    public static final String GET_TEAM_BY_ID = "SELECT * FROM team WHERE id = :id";

    /** Player queries */
    public static final String GET_PLAYERS_BY_TEAM_ID = "SELECT * FROM PUBLIC.PLAYER WHERE TEAM_ID = :team_id";
}
