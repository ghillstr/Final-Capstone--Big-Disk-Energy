package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.League;

public interface LeagueDAO {
	
	 
	
	 
	 
	 
	 void invitePlayers(League invite);
	 
	 public List<League> getPendingInvitesbyUsername(String username);
	 
	 public void setTeeTime(League teeTime);
	 
	 List<League> viewTeeTimesByUsername(String username);

	void createLeague(League league);

	void updateInvite(League invite);

	List<League> viewLeaguesByUsername(String username);
	
	List<League> viewTeeTimesByLeagueName(String leagueName);
	
	int findLeagueIdByLeagueName(String leagueName);


	 
	 

}
