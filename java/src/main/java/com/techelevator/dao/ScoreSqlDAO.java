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

	@Override
	public void recordScore(Score score) {

		String sql = "INSERT INTO scores (round_id, username, league_name, score_total) " + 

				"VALUES (DEFAULT, ?, ?, ?)";
		
		jdbcTemplate.update(sql, score.getUsername(), score.getLeagueName(), score.getScoreTotal());
		
	}
	
	@Override
	public List<Score> getAllScoresByLeagueName(String leagueName) {
		List<Score> allScores = new ArrayList<>();
		String sql = "SELECT username, SUM(score_total) AS total " + 
				"FROM scores " + 
				"WHERE league_name = ? " + 
				"GROUP BY username " + 
				"ORDER BY total";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueName);
		
		while(results.next()) {
			Score scores = mapRowToScore(results);
			allScores.add(scores);
//			Score scores = new Score();
//			scores.setLeagueName(results.getString("league_name"));
//			scores.setUsername(results.getString("username"));
//			scores.setScoreTotal(results.getInt("total"));
//			allScores.add(scores);
		}

		return allScores;
	}
	
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
	



	
//	public void mapRowToRecordScore(SqlRowSet rowSet) {
//		Score score = new Score();
//		score.setUserId(rowSet.getInt("user_id"));
//		score.setLeagueId(rowSet.getInt("league_id"));
//		score.setRoundScore(rowSet.getInt("score_total"));
//	}

	
//	@Override
//	public Score userSendScore(Score score) {
//		
//		return null;
//	}
	
    private Score mapRowToScore(SqlRowSet rs) {
        Score score = new Score();
        score.setUsername(rs.getString("username"));
        score.setScoreTotal(rs.getInt("total"));
//        score.setLeagueName(rs.getString("league_name"));
        return score;
    }
	
}