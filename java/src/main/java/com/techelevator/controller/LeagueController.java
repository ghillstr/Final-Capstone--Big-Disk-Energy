package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.LeagueDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.League;

@CrossOrigin
@RestController
@PreAuthorize(value ="isAuthenticated()")
public class LeagueController {
	
	private LeagueDAO leagueDAO;
	private UserDAO userDAO;
	
	public LeagueController (LeagueDAO leagueDAO, UserDAO userDAO) {
		this.leagueDAO = leagueDAO;
	}
	
	//WORKING
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/league/{username}", method = RequestMethod.GET )
	public List<League> viewLeaguesByUsername(Principal principal) {
		return leagueDAO.viewLeaguesByUsername(principal);
	}
	
	//WORKING
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( value = "/league", method = RequestMethod.POST )
	public void createLeague(@Valid @RequestBody League league) {
		leagueDAO.createLeague(league);
	}
	
	//WORKING
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/league/invite", method = RequestMethod.POST) //put ?
	public void invitePlayers(@Valid @RequestBody League invite) {
			
		leagueDAO.invitePlayers(invite);
	}
		
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/invites", method = RequestMethod.GET )
	public List<League> getPendingInvitesByUsername(Principal principal) {
		return leagueDAO.getPendingInvitesbyUsername(principal);
	}
		
	//WORKING
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/invites/status", method = RequestMethod.PUT)
	public void updateInvite(@Valid @RequestBody League league) {
		leagueDAO.updateInvite(league);
	}
	
	//WORKING
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/league/tee-times", method = RequestMethod.POST )
	public void setTeeTime(@Valid @RequestBody League teeTime) {

		leagueDAO.setTeeTime(teeTime);
	}
		
	//WORKING
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/tee-times", method = RequestMethod.GET )
	public List<League> viewTeeTimesByUsername(Principal principal) {
		return leagueDAO.viewTeeTimesByUsername(principal);
	}
	
	//WORKING
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/tee-times/{leagueName}", method = RequestMethod.GET)
	public List<League> viewTeeTimesByLeagueName(@PathVariable String leagueName) {
		return leagueDAO.viewTeeTimesByLeagueName(leagueName);
	}
	

}
