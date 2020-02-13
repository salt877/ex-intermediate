package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリクラスです.
 * 
 * @author rinashioda
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {

		Hotel hotel = new Hotel();

		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNeareatStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));

		return hotel;
	};

	/**
	 * 入力された価格以下のホテル情報一覧を検索する.
	 * @param price 価格
	 * @return ホテル情報一覧
	 */
	public List<Hotel> findByPrice(Integer price) {

		String sql = "SELECT id,area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price ORDER BY price DESC";

		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);

		return hotelList;
	}

	/**
	 * 全件検索する.
	 * @return 全件検索結果
	 */
	public List<Hotel> findAll() {
		
		String sql="SELECT id,area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price DESC";
		
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);

		return hotelList;
	}

}