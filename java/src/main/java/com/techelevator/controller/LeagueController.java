package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.LeagueDAO;
import com.techelevator.model.League;

@CrossOrigin
@RestController
@PreAuthorize(value ="isAuthenticated()")
public class LeagueController {
	
	private LeagueDAO leagueDAO;
	
	public LeagueController (LeagueDAO leagueDAO) {
		this.leagueDAO = leagueDAO;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/a", method = RequestMethod.GET )
	public List<League> viewLeaguesByUsername(String username) {
		return leagueDAO.viewLeaguesByUsername(username);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/b", method = RequestMethod.POST )
	public void createLeague(@Valid @RequestBody String leagueName, String courseName, String username) {
		leagueDAO.createLeague(leagueName, courseName, username);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/c", method = RequestMethod.GET)
	public List<League> viewTeeTimesByLeagueName(String leagueName) {
		return leagueDAO.viewTeeTimesByLeagueName(leagueName);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/d", method = RequestMethod.PUT) //put ?
	public void invitePlayers(String username, String leagueName) {
		leagueDAO.invitePlayers(username, leagueName);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/e", method = RequestMethod.PUT)
	public void updateInvite(@Valid @RequestBody String username, String leagueName, long invite) {
		leagueDAO.updateInvite(username, leagueName, invite);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/f", method = RequestMethod.GET )
	public List<League> getPendingInvitesByUsername(String username, String leagueName) {
		return leagueDAO.getPendingInvitesbyUsername(username, leagueName);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/g", method = RequestMethod.POST )
	public void setTeeTime(@Valid @RequestBody String username, String leagueName, String date, String startTime) {
		leagueDAO.setTeeTime(username, leagueName, date, startTime);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping( path = "/h", method = RequestMethod.GET )
	public List<League> viewTeeTimesByUsername(String username) {
		return leagueDAO.viewTeeTimesByUsername(username);
	}
}
