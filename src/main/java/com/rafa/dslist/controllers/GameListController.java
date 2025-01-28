package com.rafa.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.dslist.dto.GameListDTO;
import com.rafa.dslist.dto.GameMinDTO;
import com.rafa.dslist.dto.ReplacementDTO;
import com.rafa.dslist.services.GameListService;
import com.rafa.dslist.services.GameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @Operation(description = "Returns all game lists")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns all game lists."),
        @ApiResponse(responseCode = "404", description = "There are no registered game lists")
    })
    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @Operation(description = "Returns all games from a especified game list")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Returns all games from a game list."),
        @ApiResponse(responseCode = "404", description = "There are no registered games in the games list")
    })
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findAll(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
    
    @Operation(description = "Move game position in a game list with specific id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Replace game position in the game list"),
        @ApiResponse(responseCode = "404", description = "That is invalid position")
    })
    @PostMapping(value = "/{gameListId}/replacement")
    public void getMethodName(@PathVariable Long gameListId, @RequestBody ReplacementDTO body) {
        System.out.println("====================" + body.getSourceIndex() + body.getDestinationIndex());
        gameListService.moveGamePosition(gameListId, body.getSourceIndex(), body.getDestinationIndex());
    }   
}
