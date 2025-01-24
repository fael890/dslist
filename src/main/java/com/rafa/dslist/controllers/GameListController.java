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

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findAll(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
    
    @PostMapping(value = "/{gameListId}/replacement")
    public void getMethodName(@PathVariable Long gameListId, @RequestBody ReplacementDTO body) {
        System.out.println("====================" + body.getSourceIndex() + body.getDestinationIndex());
        gameListService.moveGamePosition(gameListId, body.getSourceIndex(), body.getDestinationIndex());
    }   
}
