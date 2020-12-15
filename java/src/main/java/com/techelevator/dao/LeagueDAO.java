package com.techelevator.dao;

import java.security.Principal;
import java.util.List;

import com.techelevator.model.League;

public interface LeagueDAO {
	
	 
	
	 
	 
	 
	 void invitePlayers(League invite);
	 
	 public List<League> getPendingInvitesbyUsername(Principal principal);
	 
	 public void setTeeTime(League teeTime);
	 
	 List<League> viewTeeTimesByUsername(Principal principal);

	void createLeague(League league);

	void updateInvite(Principal principal, League invite);

	List<League> viewLeaguesByUsername(Principal principal);
	
	List<League> viewTeeTimesByLeagueName(String leagueName);
	
	int findLeagueIdByLeagueName(String leagueName);
	
	int findUserIdByUsernameInLeague(Principal principal);

	int findIdByUsernameInLeague(League teeTime);

	
	


	 
	 

}
