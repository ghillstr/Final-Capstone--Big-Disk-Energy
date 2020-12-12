package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.League;
import com.techelevator.model.User;

@Component
public class LeagueSqlDAO implements LeagueDAO {
	
	private JdbcTemplate jdbcTemplate;

    public LeagueSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<League> viewLeaguesByUsername(String username) {
		List<League> leagues =new ArrayList<>();
		
		String sqlSelectAllLeagues = "SELECT u.user_id, u.username, l.league_id, l.league_name FROM leagues l JOIN users_leagues USING(league_id) JOIN users u USING(user_id)";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllLeagues);
		
		while (result.next()) {
			League theLeague = mapRowToLeague(result);
			
			leagues.add(theLeague);
		}
		return leagues;
	}

	@Override
	public void createLeague(String leagueName, String courseName) {
		// TODO Auto-generated method stub //post
	
		String sql = "INSERT INTO leagues (league_id, league_name, course_name) VALUES (DEFAULT, ?, ?)";
		
		jdbcTemplate.update(sql, leagueName, courseName);
		
		
	}

	@Override
	public void updateRole(String role) {
		// TODO Auto-generated method stub //put
		
	}

	@Override
	public void invitePlayers(String username, String leagueName) {
		// TODO Auto-generated method stub //post
		
		String sql = "INSERT INTO invite (invite_id, status_id, league_name, user_name) VALUES (DEFUALT, 1, ?, ?)"; 
		
		jdbcTemplate.update(sql, leagueName, username);
		 
		
	}

	@Override
	public void updateInvite(String username, String leagueName, long invite) {
		
		if(invite == 2) {
			
			String sql = "INSERT INTO invite (invite_id, status_id, league_name, user_name) VALUES (DEFAULT, 2, ?, ?)";
			
			jdbcTemplate.update(sql, leagueName, username, invite);
		} else if (invite == 3) {
			
			String sql = "INSERT INTO invite (invite_id, status_id, league_name, user_name) VALUES (DEFAULT, 3, ?, ?)";
			
			jdbcTemplate.update(sql, leagueName, username, invite);
			
		} 
		// TODO Auto-generated method stub //put
		
		
	}

	@Override
	public List<League> getPendingInvitesbyUsername(String username, String leagueName) {
		// TODO Auto-generated method stub //get
		List<League> invites = new ArrayList<>();
		
		String sql = "SELECT invite.* FROM invite WHERE username = ? AND league_name= ? AND status_id = 1";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username, leagueName);
		
		while (result.next()) {
			League theInvite = mapRowToLeague(result);
			
			invites.add(theInvite);
		}
		
		return invites;
	}
		
		
	@Override
	public void setTeeTime( String username, String leagueName, String date, String startTime) {
		// TODO Auto-generated method stub //post
		String sql = "INSERT INTO tee_time (tee_time_id, username, league_name, tee_date, time_start) VALUES (DEFAULT, ?, ?, ?, ?)";
				
		jdbcTemplate.update(sql, username, leagueName, date, startTime);
	}

	@Override
	public List<League> viewTeeTimesByUsername(String username) {
	
		List<League> teeTimes = new ArrayList<>();
		
		String sql = "SELECT tee_date, time_start FROM tee_time WHERE username = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
		
		while (result.next()) {
			League theTeeTime = mapRowToLeague(result);
			
			teeTimes.add(theTeeTime);
		}
		return teeTimes;
	}
	@Override
	public List<League> viewTeeTimesByLeagueName(String leagueName) {
	
		List<League> teeTimes = new ArrayList<>();
		
		String sql = "SELECT tee_date, time_start FROM tee_time WHERE league_name = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, leagueName);
		
		while (result.next()) {
			League theTeeTime = mapRowToLeague(result);
			
			teeTimes.add(theTeeTime);
		}
		return teeTimes;
	}

	private League mapRowToLeague(SqlRowSet rowSet) {
		
		League theLeague = new League();
		
		theLeague.setLeagueId(rowSet.getLong("league_id"));
		theLeague.setLeagueName(rowSet.getString("league_name"));
		theLeague.setCourseName(rowSet.getString("course_name"));
		theLeague.setStatusId(rowSet.getLong("status_id"));
		theLeague.setInviteStatus(rowSet.getString("status_type"));
		theLeague.setTeeTimeId(rowSet.getLong("tee_time_id"));
		theLeague.setDate(rowSet.getString("tee_date"));
		theLeague.setStartTime(rowSet.getString("start_time"));
		
		return theLeague;
		
	}

	


}
