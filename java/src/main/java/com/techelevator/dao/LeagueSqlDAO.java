package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.League;

@Component
public class LeagueSqlDAO implements LeagueDAO {
	
	private JdbcTemplate jdbcTemplate;

    public LeagueSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<League> viewLeaguesByUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public League createLeague(String leagueName, String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public League updateRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public League invitePlayers(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInvite(League league) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public League[] getPendingInvites(League league) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public League setTeeTime(long TeeTimeId, String date, String startTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<League> viewTeeTimesByUsername() {
		// TODO Auto-generated method stub
		return null;
	}



}
