package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.Hotel;
import com.example.Form.HotelForm;
import com.example.Service.HotelService;

/**
 * hotelsテーブルを操作するコントローラークラスです.
 * 
 * @author rinashioda
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	/**
	 * フォームオブジェクトをリクエストスコープに格納.
	 * @return 格納したフォームオブジェクト
	 */
	@ModelAttribute
	public HotelForm setUpForm() {
		return new HotelForm();
	}

	private List<Hotel> hotelList;

	@Autowired
	private HotelService hotelService;

	@RequestMapping("")
	public String index() {
		return "hotelSearch";
	}

	/**
	 * 受け取ったリクエストパラメータを使って検索する.
	 * @param hotelForm リクエストパラメータを受け取るフォーム
	 * @param model リクエストスコープ
	 * @return 検索結果
	 */
	@RequestMapping("/result")
	public String searchByLessThanPrice(HotelForm hotelForm, Model model) {

		hotelList = hotelService.searchByLessThanPrice(hotelForm.getPrice());

		model.addAttribute("hotelList", hotelList);
		
		return "hotelSearch";
	}

}
