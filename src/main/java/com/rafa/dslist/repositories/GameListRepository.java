package com.rafa.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafa.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
