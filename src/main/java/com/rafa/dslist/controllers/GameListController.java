package com.rafa.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.dslist.dto.GameListDTO;
import com.rafa.dslist.services.GameListService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/lists")
public class GameListController {
    @Autowired
    GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
    
}
