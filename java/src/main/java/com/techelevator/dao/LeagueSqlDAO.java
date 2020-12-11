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
	public List<League> viewLeaguesByUserId() {
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
	public League createLeague(String leagueName, String courseName) {
		// TODO Auto-generated method stub //post
		return null;
	}

	@Override
	public League updateRole(String role) {
		// TODO Auto-generated method stub //put
		return null;
	}

	@Override
	public League invitePlayers(long userId) {
		// TODO Auto-generated method stub //post
		return null;
	}

	@Override
	public boolean updateInvite(League league) {
		// TODO Auto-generated method stub //put
		return false;
	}

	@Override
	public League[] getPendingInvites(League league) {
		// TODO Auto-generated method stub //get
		return null;
	}

	@Override
	public League setTeeTime(long TeeTimeId, String date, String startTime) {
		// TODO Auto-generated method stub //post
		return null;
	}

	@Override
	public List<League> viewTeeTimesByUsername() {
		// TODO Auto-generated method stub //get
		return null;
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
