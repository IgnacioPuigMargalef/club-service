package com.footballscore.clubservice.Controller;

import com.footballscore.clubservice.Controller.Response.CustomErrorResponse;
import com.footballscore.clubservice.Exception.NotFoundTeamException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    /* Error code */
    public final String NOT_FOUND_TEAM_CODE = "NOT_FOUND_TEAM";

    @ExceptionHandler(value = NotFoundTeamException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public CustomErrorResponse onNotFoundTeamException() {
        return new CustomErrorResponse(NOT_FOUND_TEAM_CODE);
    }

}
