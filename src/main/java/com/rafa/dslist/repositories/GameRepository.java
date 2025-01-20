package com.rafa.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafa.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
