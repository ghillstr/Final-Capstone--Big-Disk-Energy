package com.techelevator.model;

public class Score {
	
	private String username;
	private String leagueName;
	private int scoreTotal;
	
	public Score() {
		
	}
	
	public Score(String username, int scoreTotal) {
		this.username = username;
		this.scoreTotal = scoreTotal;
	}
	
	public Score(String username, String leagueName, int scoreTotal) {
		this.username = username;
		this.username = username;
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
