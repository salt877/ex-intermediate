package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Domain.Clothes;
import com.example.Repository.ClothesRepository;

@Service
public class ClothesService {

	@Autowired
	private ClothesRepository clothesRepository;

	public List<Clothes> searchByColorAndGender(String gender, String color) {

		return clothesRepository.findByGenderColor(Integer.parseInt(gender), color);

	}

}
