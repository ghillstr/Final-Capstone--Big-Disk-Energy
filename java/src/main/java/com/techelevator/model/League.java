package com.techelevator.model;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class League {
	
	private int leagueId;
	private String username;
	private int userId;
	private String leagueName;
	private String courseName;
	private int statusId;
	private String inviteStatus;
	private long teeTimeId;
	private Date date;
	@JsonFormat(pattern = "HH:mm")
	@JsonDeserialize(using = com.techelevator.SqlTimeDeserializer.class)

	private Time startTime;
	
	public League() {
	
	}
	
	public League(int leagueId, String username, int userId, String leagueName, String courseName, int statusId, String inviteStatus, long teeTimeId,
			Date date, Time startTime) {
		super();
		this.leagueId = leagueId;
		this.username = username;
		this.userId = userId;
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

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	
}
