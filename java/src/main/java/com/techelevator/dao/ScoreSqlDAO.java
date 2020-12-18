package com.techelevator.dao;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Score;

@Component
public class ScoreSqlDAO implements ScoreDAO {
	private JdbcTemplate jdbcTemplate;
	
	public ScoreSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//WORKING
	@Override
	public void recordScore(Score score) {

		String sql = "INSERT INTO scores (round_id, username, league_name, score_total) " + 

				"VALUES (DEFAULT, ?, ?, ?)";
		
		jdbcTemplate.update(sql, score.getUsername(), score.getLeagueName(), score.getScoreTotal());
		
	}
	
	//WORKING
	@Override
	public List<Score> getAllScoresByLeagueName(String leagueName) {
		List<Score> allScores = new ArrayList<>();
		String sql = "SELECT username, SUM(score_total) AS total, COUNT(round_id) AS rounds " + 
				"FROM scores " + 
				"WHERE league_name = ? " + 
				"GROUP BY username " + 
				"ORDER BY total";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueName);
		
		while(results.next()) {
			Score scores = mapRowToScore(results);
			allScores.add(scores);

		}

		return allScores;
	}
	
	//WORKING
	@Override
	public List<Score> getAllScoresByUsername(Principal principal, String leagueName) {
		List<Score> scoresByUsername = new ArrayList<>();
		String sql = "SELECT score_total " +
				"FROM scores " + 
				"WHERE username = ? AND league_name = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName(), leagueName);
		
		while(results.next()) {
			Score scores = new Score();
			scores.setScoreTotal(results.getInt("score_total"));
			scoresByUsername.add(scores);
		}
		
		return scoresByUsername;
	}
	
    private Score mapRowToScore(SqlRowSet rs) {
        Score score = new Score();
        score.setUsername(rs.getString("username"));
        score.setScoreTotal(rs.getInt("total"));
        score.setRoundId(rs.getInt("rounds"));
        return score;
    }
	
}