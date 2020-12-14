package com.techelevator.model;

public class League {
	
	private long leagueId;
	private String username;
	private String leagueName;
	private String courseName;
	private int statusId;
	private String inviteStatus;
	private long teeTimeId;
	private String date;
	private String startTime;
	
	public League() {
	
	}
	

	public League(long leagueId, String leagueName, String courseName, int statusId, String inviteStatus, long teeTimeId,
			String date, String startTime, long userId) {
		super();
		this.leagueId = leagueId;
		this.username = username;
		this.leagueName = leagueName;
		this.courseName = courseName;
		this.statusId = statusId;
		this.inviteStatus = inviteStatus;
		this.teeTimeId = teeTimeId;
		this.date = date;
		this.startTime = startTime;
		
	}


	public long getLeagueId() {
		return leagueId;
	}


	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public String getInviteStatus() {
		return inviteStatus;
	}


	public void setInviteStatus(String inviteStatus) {
		this.inviteStatus = inviteStatus;
	}


	public String getLeagueName() {
		return leagueName;
	}


	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public long getTeeTimeId() {
		return teeTimeId;
	}


	public void setTeeTimeId(long teeTimeId) {
		this.teeTimeId = teeTimeId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	

}
