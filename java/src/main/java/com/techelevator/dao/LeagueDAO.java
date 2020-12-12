package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.League;

public interface LeagueDAO {
	
	 
	
	 
	 
	 
	 void invitePlayers(String username, String leagueName);
	 
	 
	 public List<League> getPendingInvitesbyUsername(String username, String leagueName);
	 
	 public void setTeeTime( String username, String leagueName, String date, String startTime);
	 
	 List<League> viewTeeTimesByUsername(String username);

	void createLeague(String leagueName, String courseName, String username);

	void updateInvite(String username, String leagueName, long invite);

	List<League> viewLeaguesByUsername(String username);
	
	List<League> viewTeeTimesByLeagueName(String leagueName);
	

	 
	 

}
