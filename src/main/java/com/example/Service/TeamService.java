package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Domain.Team;
import com.example.Repository.TeamRepository;

/**
 * teamsテーブルを操作するサービスクラスです.
 * @author rinashioda
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	

	/**
	 * 主キーを使ってリポジトリのloadメソッドを呼び出す.
	 * @param id
	 * @return 一件検索した結果
	 */
	public Team showDetail(Integer id) {

		Team team = teamRepository.load(id);

		return team;
	}

	/**
	 * リポジトリのfindAllメソッドを呼び出す.
	 * @return 全件検索した結果
	 */
	public List<Team> showList() {

		List<Team> teamList = teamRepository.findAll();
		
		return teamList;
	}

}
