package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Domain.Hotel;
import com.example.Repository.HotelRepository;

/**
 * hotelsテーブルを操作するサービスクラスです.
 * 
 * @author rinashioda
 *
 */
@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	/**
	 * 入力された金額を使って検索する.
	 * 何も入力されなければ全件を表示.
	 * @param price 価格
	 * @return 全件検索結果
	 * @return 入力した価格より安いホテルの検索結果
	 */
	public List<Hotel> searchByLessThanPrice(String price) {

		if ("".equals(price)) {
			return hotelRepository.findAll();
		} else {
			return hotelRepository.findByPrice(Integer.parseInt(price));
		}

	}

}
