package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.Team;
import com.example.Service.TeamService;

/**
 * 野球チーム情報を操作するコントローラークラスです.
 * @author rinashioda
 *
 */

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	/**
	 * 授業員一覧画面を出力します.
	 * @return チーム一覧
	 */
	
	@RequestMapping("/showList")
	public String showList(Model model) {
		
		List<Team> teamList = teamService.showList();
		
		model.addAttribute("teamList",teamList);

		return "teamList";

	}

	/**
	 * 野球チームの詳細画面を出力します.
	 * 
	 * @param id ID
	 * @param model リクエストスコープ
	 * @return チーム情報詳細
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {

		Team team = teamService.showDetail(Integer.parseInt(id));

		model.addAttribute("team", team);

		return "teamDetail";

	}

}
