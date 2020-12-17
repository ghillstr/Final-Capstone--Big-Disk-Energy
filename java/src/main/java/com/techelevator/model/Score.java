package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class Score {
	

	private String username;
	//@NotNull(message = "The field `transfer type id` should not be blank.")
	private String leagueName;
	private int scoreTotal;
	private int roundId;
	
	public Score() {
		
	}
	
	public Score(String username, int scoreTotal, String leagueName, int roundId) {
		this.username = username;
		this.scoreTotal = scoreTotal;
		this.leagueName = leagueName;
		this.roundId = roundId;
	}
	
//	public Score(String username, String leagueName, int scoreTotal) {
//		this.username = username;
//		this.leagueName = leagueName;
//		this.scoreTotal = scoreTotal;
//	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getScoreTotal() {
		return scoreTotal;
	}
	
	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	public int getRoundId() {
		return roundId;
	}
	
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}


	
	
}
