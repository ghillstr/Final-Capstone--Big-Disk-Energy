package com.techelevator.model;

public class League {
	
	private int leagueId;
	private String leagueName;
	private String courseName;
	private int statusId;
	private String inviteStatus;
	private int teeTimeId;
	private String date;
	private String startTime;
	
	

	public League(int leagueId, String leagueName, String courseName, int statusId, String inviteStatus, int teeTimeId,
			String date, String startTime) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.courseName = courseName;
		this.statusId = statusId;
		this.inviteStatus = inviteStatus;
		this.teeTimeId = teeTimeId;
		this.date = date;
		this.startTime = startTime;
	}


	public int getLeagueId() {
		return leagueId;
	}


	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
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
	
	public int getTeeTimeId() {
		return teeTimeId;
	}


	public void setTeeTimeId(int teeTimeId) {
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
