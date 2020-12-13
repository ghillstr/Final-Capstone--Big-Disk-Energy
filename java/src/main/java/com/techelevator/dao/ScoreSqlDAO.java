package com.techelevator.dao;

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
		String sql = "INSERT INTO scores (round _id, username, leaguename, score_total) " + 
				"VALUES (DEFAULT, ?, ?, ?)";
		
		jdbcTemplate.update(sql, score.getUsername(), score.getLeagueName(), score.getScoreTotal());
		
	}

	@Override
	public List<Score> getAllScoresByLeagueName(Score score) {
		 List<Score> allScores = new ArrayList<>();
		String sql = "SELECT username, SUM(score_total) AS total " + 
				"FROM scores " + 
				"WHERE league_name = ? " + 
				"GROUP BY username " + 
				"ORDER BY total";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,score.getLeagueName());
		
//		while(results.next()) {
//			Score score = 
//		}
	
		
		return allScores;
	}

	@Override
	public List<Score> getAllScoresByUsername(Score score) {
		
		return null;
	}
	
//	@Override
//	public Score userSendScore(Score score) {
//		
//		return null;
//	}
	
}