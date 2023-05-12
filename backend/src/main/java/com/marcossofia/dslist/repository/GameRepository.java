package com.marcossofia.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcossofia.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game,Long>{

}
