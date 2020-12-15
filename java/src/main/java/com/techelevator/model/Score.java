package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class Score {
	

	private String username;
	@NotNull(message = "The field `transfer type id` should not be blank.")
	private String leagueName;
	private int scoreTotal;
	
	public Score() {
		
	}
	
	public Score(String username, int scoreTotal, String leagueName) {
		this.username = username;
		this.scoreTotal = scoreTotal;
	}
	
	public Score(String username, String leagueName, int scoreTotal) {
		this.username = username;
//		this.leagueName = leagueName;
		this.scoreTotal = scoreTotal;
	}
	
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


	
	
}
