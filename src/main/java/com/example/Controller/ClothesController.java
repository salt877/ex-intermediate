package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.Clothes;
import com.example.Form.ClothesForm;
import com.example.Service.ClothesService;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

	@ModelAttribute
	public ClothesForm setUpForm() {
		return new ClothesForm();
	}
	private List<Clothes> clothesList;
	
	@Autowired
	private ClothesService clothesService;

	@RequestMapping("")
	public String index() {
		return "clothes";

	}

	@RequestMapping("/result")
	public String searchByColorAndGender(ClothesForm clothesForm, Model model) {

		clothesList = clothesService.searchByColorAndGender(clothesForm.getGender(),clothesForm.getColor());

		model.addAttribute("clothesList", clothesList);
		
		System.out.println(clothesList);

		return "clothes";
	}

}
