package com.marcossofia.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcossofia.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList,Long>{

}
