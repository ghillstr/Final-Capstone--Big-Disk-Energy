package com.techelevator.dao;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.League;

@Component
public class LeagueSqlDAO implements LeagueDAO {
	
	private JdbcTemplate jdbcTemplate;
	private UserSqlDAO dao;

    public LeagueSqlDAO(JdbcTemplate jdbcTemplate, UserSqlDAO dao) {
        this.jdbcTemplate = jdbcTemplate;
        this.dao = dao;
    }

    //WORKING
	@Override
	public List<League> viewLeaguesByUsername(Principal principal) {
		List<League> leagues =new ArrayList<>();
		
		String sqlSelectAllLeagues = "SELECT l.league_name FROM leagues l JOIN users_leagues USING(league_id) JOIN users u USING(user_id) WHERE u.username = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectAllLeagues, principal.getName());
		
		while (result.next()) {
			League theLeagues = new League();
			theLeagues.setLeagueName(result.getString("league_name"));
			leagues.add(theLeagues);
		}
		return leagues;
	}

	//WORKING
	@Override
	public void createLeague(Principal principal, League league) {
		
		String sql = "INSERT INTO leagues (league_id, league_name, course_name, username) VALUES (DEFAULT, ?, ?, ?)";
		
		jdbcTemplate.update(sql, league.getLeagueName(), league.getCourseName(), league.getUsername());
		
		insertLeagueAdminWhenLeagueCreated(principal, league);
		
	}
	
	public void insertLeagueAdminWhenLeagueCreated(Principal principal, League league) {
		
		String sql2 = "INSERT INTO users_leagues (user_id, league_id) VALUES(?, ?)";
		
		jdbcTemplate.update(sql2, findIdByUsername(principal), findLeagueIdByLeagueName(league.getLeagueName()));
		
	}


	//WORKING
	@Override
	public void invitePlayers(League invite) {
		
		String sql = "INSERT INTO invite (invite_id, status_id, league_id, league_name, user_id, username) VALUES (DEFAULT, 1, ?, ?, ?, ?)"; 
		

		jdbcTemplate.update(sql, findLeagueIdByLeagueName(invite.getLeagueName()), invite.getLeagueName(), findIdByUsernameInLeague(invite), invite.getUsername());

		
	}

	//WORKING
	@Override
	public List<League> getPendingInvitesbyUsername(Principal principal) {
		// TODO Auto-generated method stub //get
		List<League> invites = new ArrayList<>();
		
		String sql = "SELECT league_name FROM invite WHERE username = ? AND status_id = 1";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, principal.getName());
		
		while (result.next()) {
			League theInvite = new League();
			theInvite.setLeagueName(result.getString("league_name"));
			invites.add(theInvite);
		}
		
		return invites;
	}
	
	//WORKING
	@Override
	public void updateInvite(Principal principal, League invite) {
		
		if(invite.getStatusId() == 2) {
			

			String sql = "UPDATE invite SET status_id = 2 WHERE username = ? AND league_name = ?";

			
			jdbcTemplate.update(sql, principal.getName(), invite.getLeagueName());
			
			String sql2 = "INSERT INTO users_leagues (user_id, league_id) VALUES (?, ?)";
			
			jdbcTemplate.update(sql2, findUserIdByUsernameInLeague(principal), findLeagueIdByLeagueName(invite.getLeagueName()));
			
		} else if (invite.getStatusId() == 3) {
			
			String sql = "UPDATE invite SET status_id = 3 WHERE username = ? AND league_name = ?";
			
			jdbcTemplate.update(sql, principal.getName(), invite.getLeagueName());
			
		}
		
	}
		
	//WORKING
	@Override
	public void setTeeTime(League teeTime) {
		
		String sql = "INSERT INTO tee_time (tee_time_id, user_id, username, league_id, league_name, tee_date, start_time) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)";
				
		jdbcTemplate.update(sql, findIdByUsernameInLeague(teeTime), teeTime.getUsername(), findLeagueIdByLeagueName(teeTime.getLeagueName()), teeTime.getLeagueName(), teeTime.getDate(), teeTime.getStartTime());
		
	}

	//WORKING
	@Override
	public List<League> viewTeeTimesByUsername(Principal principal) {
	
		List<League> teeTimes = new ArrayList<>();
		
		String sql = "SELECT league_name, tee_date, start_time FROM tee_time WHERE username = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, principal.getName());
		
		while (result.next()) {
			League teeTime = new League();
			teeTime.setLeagueName(result.getString("league_name"));
			teeTime.setDate(result.getString("tee_date"));
			teeTime.setStartTime(result.getString("start_time"));
			teeTimes.add(teeTime);
			
		}
		return teeTimes;
	}
	
	//WORKING
	@Override
	public List<League> viewTeeTimesByLeagueName(String leagueName) {
	
		List<League> teeTimes = new ArrayList<>();
		
		String sql = "SELECT tee_date, start_time FROM tee_time WHERE league_name = ?";
		
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, leagueName);
		
		while (result.next()) {
			League theTeeTime = new League();
			theTeeTime.setDate(result.getString("tee_date"));
			theTeeTime.setStartTime(result.getString("start_time"));
			
			teeTimes.add(theTeeTime);
		}
		return teeTimes;
	}
	
	@Override
    public int findLeagueIdByLeagueName(String leagueName) {
		
        int leagueId = jdbcTemplate.queryForObject("select league_id from leagues where league_name = ?", int.class, leagueName);
        
        return leagueId;

    }
	
	@Override
	public int findIdByUsernameInLeague(League teeTime) {
		
		int userIdForTeeTime = dao.findIdByUsername(teeTime.getUsername());
		
		return userIdForTeeTime;
	}
	
	@Override
	public int findUserIdByUsernameInLeague(Principal principal) {
		
		int userIdForTeeTime = dao.findIdByUsername(principal.getName());
		
		return userIdForTeeTime;
	}
	
	@Override
    public int findIdByUsername(Principal principal) {
        return jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, principal.getName());
    }

//	private League mapRowToLeague(SqlRowSet rowSet) {
//		
//		League theLeague = new League();
//		
//		theLeague.setLeagueId(rowSet.getInt("league_id"));
//		theLeague.setLeagueName(rowSet.getString("league_name"));
//		theLeague.setCourseName(rowSet.getString("course_name"));
//		theLeague.setStatusId(rowSet.getInt("status_id"));
//		theLeague.setInviteStatus(rowSet.getString("status_type"));
//		theLeague.setTeeTimeId(rowSet.getLong("tee_time_id"));
//		theLeague.setDate(rowSet.getString("tee_date"));
//		theLeague.setStartTime(rowSet.getString("start_time"));
//		
//		return theLeague;
//		
//	}

	


}
