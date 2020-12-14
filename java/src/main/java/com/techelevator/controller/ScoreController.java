package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
//	@PreAuthorize("hasRole(LEAGUE_ADMIN)")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/score", method = RequestMethod.POST )
	public void recordScore(@Valid @RequestBody Score score) {
		scoreDAO.recordScore(score);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/leagueScores/leaderboard", method = RequestMethod.GET )
	public List<Score> getAllScoresByLeagueName(@Valid @RequestBody Score score) {
		return scoreDAO.getAllScoresByLeagueName(score);
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/leagueScores", method = RequestMethod.GET )
	public List<Score> getAllScoresByUsername(Score score) {
		return scoreDAO.getAllScoresByUsername(score);
	}
	
	
	
	
	
	
	
}