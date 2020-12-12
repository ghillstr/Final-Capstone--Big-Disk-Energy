package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.League;

public interface LeagueDAO {
	
	 
	
	 
	 void updateRole(String role);
	 
	 void invitePlayers(String username, String leagueName);
	 
	 
	 public List<League> getPendingInvitesbyUsername(String username, String leagueName);
	 
	 League setTeeTime(long TeeTimeId, String date, String startTime);
	 
	 List<League> viewTeeTimesByUsername();

	List<League> viewLeaguesByUserId();

	void createLeague(String leagueName, String courseName);

	void updateInvite(String username, String leagueName, long invite);
	 
	 

}
