package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Domain.Team;
import com.example.Repository.TeamRepository;

/**
 * @author rinashioda
 *
 */
@Service
@Transactional
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Team showDetail(Integer id) {

		Team team = teamRepository.load(id);

		return team;
	}

	/**
	 * 
	 * @return
	 */
	public List<Team> showList() {

		List<Team> teamList = teamRepository.findAll();
		
		return teamList;
	}

}
