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
	
	@RequestMapping( path = "/a", method = RequestMethod.GET )
	public List<League> viewLeaguesByUsername() {
		return leagueDAO.viewLeaguesByUsername();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/b", method = RequestMethod.POST )
	public League createLeague(@Valid @RequestBody String leagueName, String courseName) {
		return leagueDAO.createLeague(leagueName, courseName);
	}
	
	@RequestMapping( path = "/c", method = RequestMethod.PUT)
	public League updateRole(@Valid @RequestBody String role) {
		return leagueDAO.updateRole(role);
	}
	
	@RequestMapping( path = "/d", method = RequestMethod.PUT) //put ?
	public League invitePlayers(long userId) {
		return leagueDAO.invitePlayers(userId);
	}
	
	@RequestMapping( path = "/e", method = RequestMethod.PUT)
	public boolean updateInvite(@Valid @RequestBody League league) {
		return leagueDAO.updateInvite(league);
	}
	
	@RequestMapping( path = "/f", method = RequestMethod.GET )
	public League[] getPendingInvites(League league) {
		return leagueDAO.getPendingInvites(league);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping( path = "/g", method = RequestMethod.POST )
	public League setTeeTime(@Valid @RequestBody long TeeTimeId, String date, String startTime) {
		return leagueDAO.setTeeTime(TeeTimeId, date, startTime);
	}
	
	@RequestMapping( path = "/h", method = RequestMethod.GET )
	public List<League> viewTeeTimesByUsername() {
		return leagueDAO.viewTeeTimesByUsername();
	}
}
