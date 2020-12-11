package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.League;

public interface LeagueDAO {
	
	 
	 League createLeague(String leagueName, String courseName);
	 
	 League updateRole(String role);
	 
	 League invitePlayers(long userId);
	 
	 boolean updateInvite(League league);
	 
	 League[] getPendingInvites(League league);
	 
	 League setTeeTime(long TeeTimeId, String date, String startTime);
	 
	 List<League> viewTeeTimesByUsername();

	List<League> viewLeaguesByUserId();
	 
	 

}
