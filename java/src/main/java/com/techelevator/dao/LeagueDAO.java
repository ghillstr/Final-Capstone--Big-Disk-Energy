package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.League;

public interface LeagueDAO {
	
	 
	
	 
	 
	 
	 void invitePlayers(String username, String leagueName);
	 
	 
	 public List<League> getPendingInvitesbyUsername(String username);
	 
	 public void setTeeTime(League teeTime);
	 
	 List<League> viewTeeTimesByUsername(String username);

	void createLeague(League league);

	void updateInvite(League invite);

	List<League> viewLeaguesByUsername(String username);
	
	List<League> viewTeeTimesByLeagueName(String leagueName);
	
	int findLeagueIdByUsername(String username);
	

	 
	 

}
