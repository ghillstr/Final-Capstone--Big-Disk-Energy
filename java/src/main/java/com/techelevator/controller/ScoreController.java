package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ScoreDAO;
import com.techelevator.model.Score;

@CrossOrigin
@RestController
@PreAuthorize(value = "isAuthenticated()")
public class ScoreController {
	
	private ScoreDAO scoreDAO;
	
	public ScoreController (ScoreDAO scoreDAO) {
		this.scoreDAO = scoreDAO;
	}
	
	//WORKING
//	@PreAuthorize("hasRole(LEAGUE_ADMIN)")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path = "/score", method = RequestMethod.POST)
	public void recordScore(@Valid @RequestBody Score score) {
		scoreDAO.recordScore(score);

	}
	
	//WORKING
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/leaderboard/{leagueName}", method = RequestMethod.GET)
	public List<Score> getAllScoresByLeagueName(@Valid @PathVariable String leagueName) {
		return scoreDAO.getAllScoresByLeagueName(leagueName);
		
	}
	
	//WORKING
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(path = "/leagueScores/{leagueName}", method = RequestMethod.GET)
	public List<Score> getAllScoresByUsername(@Valid Principal principal, @PathVariable String leagueName) {
		return scoreDAO.getAllScoresByUsername(principal, leagueName);
	}
	
	
	
	
	
	
	
}