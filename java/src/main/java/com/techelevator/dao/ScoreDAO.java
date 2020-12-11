package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Score;

public interface ScoreDAO {
	
	Score userSendScore(Score score);
	//user sending a score to league admin
	
	Score recordScore(Score score);
	//league admin posting round scores
	
	List<Score> getAllScoresByLeagueId(Score score);
	//getting a sum of round scores WHERE leagueId and GROUPed by userId
	
	List<Score> getAllScoresByUserId(Score score);
	//get the scores of one user by the userId

}
