package com.techelevator.dao;

import java.security.Principal;
import java.util.List;

import com.techelevator.model.Score;

public interface ScoreDAO {
	
	
	void recordScore(Score score);
	//league admin posting round scores
	
	List<Score> getAllScoresByLeagueName(String leagueName);
	//getting a sum of round scores WHERE leagueId and GROUPed by userId
	
	List<Score> getAllScoresByUsername(Principal principal, String leagueName);
	//get the scores of one user by the userId

//	Score userSendScore(Score score);
//  user sending a score to league admin
	
}
