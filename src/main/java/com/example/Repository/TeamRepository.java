package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.Team;


/**
 * teamsテーブルを操作するリポジトリ.
 * 
 * @author rinashioda
 *
 */
@Repository
public class TeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {

		Team team = new Team();

		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));

		return team;

	};
	
	/**
	 * 全件検索を行って発足日順で取得します.
	 * 
	 * @return 全チーム一覧
	 */
	public List<Team> findAll() {
		
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration";
		
		List<Team> teamList = template.query(sql,TEAM_ROW_MAPPER);
		
		return teamList;
	}

	/**
	 * 主キー検索を行います.
	 * 
	 * @param id
	 * @return チーム情報
	 */
	public Team load(Integer id) {

		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id=:id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);

		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);

		
		return team;
	}

}