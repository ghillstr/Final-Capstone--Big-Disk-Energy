package com.techelevator.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.Score;

@Component
public class ScoreSqlDAO implements ScoreDAO {
	private JdbcTemplate jdbcTemplate;
	
	public ScoreSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Score userSendScore(Score score) {
		
		return null;
	}

	@Override
	public Score recordScore(Score score) {
		
		return null;
	}

	@Override
	public List<Score> getAllScoresByLeagueId(Score score) {
		
		return null;
	}

	@Override
	public List<Score> getAllScoresByUserId(Score score) {
		
		return null;
	}

	
	
}
