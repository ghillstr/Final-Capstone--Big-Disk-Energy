package com.techelevator.dao;

import java.security.Principal;
import java.util.List;

import com.techelevator.model.League;
import com.techelevator.model.User;

public interface LeagueDAO {
	
	 
	
	 
	 
	 
	 void invitePlayers(League invite);
	 
	 public List<League> getPendingInvitesbyUsername(Principal principal);
	 
	 public void setTeeTime(League teeTime);
	 
	 List<League> viewTeeTimesByUsername(Principal principal);

	void createLeague(Principal principal, League league);

	void updateInvite(Principal principal, League invite);

	List<League> viewLeaguesByUsername(Principal principal);
	
	List<League> viewTeeTimesByLeagueName(Principal principal, String leagueName);
	
	int findLeagueIdByLeagueName(String leagueName);

	int findIdByUsernameInLeague(League teeTime);
	
	List<League> getAllLeagues();
	
	int findIdByUsername(Principal principal);
	
	int findUserIdByUsernameInLeague(Principal principal);
	
//	String findCourseNameByLeagueName(League invite);

	
	


	 
	 

}
