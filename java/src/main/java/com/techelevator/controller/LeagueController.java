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
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/league/{username}", method = RequestMethod.GET )
	public List<League> viewLeaguesByUsername(@PathVariable String username) {
		return leagueDAO.viewLeaguesByUsername(username);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( value = "/league", method = RequestMethod.POST )
	public void createLeague(@Valid @RequestBody League league) {
		leagueDAO.createLeague(league);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/tee-times/{leagueName}", method = RequestMethod.GET)
	public List<League> viewTeeTimesByLeagueName(@PathVariable String leagueName) {
		return leagueDAO.viewTeeTimesByLeagueName(leagueName);
	}
	
	@ResponseStatus(HttpStatus.OK)

	@RequestMapping( path = "/league/invite", method = RequestMethod.POST) //put ?
	public void invitePlayers(@Valid @RequestBody League invite) {
		
		leagueDAO.invitePlayers(invite);
	}

	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/invites/status", method = RequestMethod.PUT)
	public void updateInvite(@Valid @RequestBody League league) {
		leagueDAO.updateInvite(league);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( value = "/invites/{username}", method = RequestMethod.GET )
	public List<League> getPendingInvitesByUsername(Principal principal, @PathVariable String username) {
		return leagueDAO.getPendingInvitesbyUsername(username);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/league/tee-times", method = RequestMethod.POST )
	public void setTeeTime(@Valid @RequestBody League teeTime) {
		leagueDAO.setTeeTime(teeTime);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/league/tee-times/{username}", method = RequestMethod.GET )
	public List<League> viewTeeTimesByUsername(String username) {
		return leagueDAO.viewTeeTimesByUsername(username);
	}
}
