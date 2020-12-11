package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.League;

public interface LeagueDAO {
	
	 List<League> viewLeaguesByUsername();
	 
	 League createLeague(String leagueName, String courseName);
	 
	 League updateRole(String role);
	 
	 League invitePlayers(int userId);
	 
	 boolean updateInvite(League league);
	 
	 League[] getPendingInvites(League league);
	 
	 League setTeeTime(int TeeTimeId, String date, String startTime );
	 
	 List<League> viewTeeTimesByUsername();
	 
	 

}
