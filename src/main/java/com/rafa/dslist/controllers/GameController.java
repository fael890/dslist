package com.rafa.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.dslist.dto.GameDTO;
import com.rafa.dslist.dto.GameMinDTO;
import com.rafa.dslist.services.GameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @Operation(description = "Returns the most relevant data of the games.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the most relevant data of the games."),
        @ApiResponse(responseCode = "404", description = "There are no registered games")
    })
    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @Operation(description = "Returns all data of a game")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns the game with specific id"),
        @ApiResponse(responseCode = "404", description = "There is no game with this id")
    })
    @GetMapping(value = "/{id}")
    public GameDTO findByID(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }
    
}
