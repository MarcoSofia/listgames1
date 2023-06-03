package com.marcossofia.dslist.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcossofia.dslist.dto.GameListDTO;
import com.marcossofia.dslist.dto.GameMinDTO;
import com.marcossofia.dslist.dto.ReplacementDTO;
import com.marcossofia.dslist.services.GameListService;
import com.marcossofia.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListControle {

	@Autowired
	private GameListService gameListService;

	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findGames(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByGameList(listId);
		return result;
	}

	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}

}
