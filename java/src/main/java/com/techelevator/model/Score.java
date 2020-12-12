package com.techelevator.model;

public class Score {
	
	private int userId;
	private String username;
	private String leagueName;
	private int roundScore;
	private int scoreTotal;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getLeagueId() {
		return leagueId;
	}
	
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	public int getRoundScore() {
		return roundScore;
	}
	
	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
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

	public void setLeagueName(String leaguename) {
		this.leagueName = leaguename;
	}
	
	
}
