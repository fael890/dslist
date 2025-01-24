package com.rafa.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafa.dslist.dto.GameListDTO;
import com.rafa.dslist.entities.GameList;
import com.rafa.dslist.projections.GameMinProjection;
import com.rafa.dslist.repositories.GameListRepository;
import com.rafa.dslist.repositories.GameRepository;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = this.gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    @Transactional
    public void moveGamePosition(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> gameList = gameRepository.searchByList(listId);

        GameMinProjection gameObject = gameList.remove(sourceIndex);
        gameList.add(destinationIndex, gameObject);

        int minorIndex = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int majorIndex = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for (int i = minorIndex; i <= majorIndex; i++) {
            gameListRepository.updateBelongingPosition(listId, gameList.get(i).getId(), i);
        }
    }
}
