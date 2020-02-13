package com.example.Domain;

/**
 * hotelsテーブルを操作するドメインクラスです.
 * @author rinashioda
 *
 */
public class Hotel {

	/** ID */
	private Integer id;
	/** 地域名 */
	private String areaName;
	/** ホテル名 */
	private String hotelName;
	/** 住所 */
	private String address;
	/** 最寄駅 */
	private String neareatStation;
	/** 価格 */
	private Integer price;
	/** 駐車場の有無 */
	private String parking;

	public Hotel() {
	}

	public Hotel(Integer id, String areaName, String hotelName, String address, String neareatStation, Integer price,
			String parking) {
		super();
		this.id = id;
		this.areaName = areaName;
		this.hotelName = hotelName;
		this.address = address;
		this.neareatStation = neareatStation;
		this.price = price;
		this.parking = parking;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNeareatStation() {
		return neareatStation;
	}

	public void setNeareatStation(String neareatStation) {
		this.neareatStation = neareatStation;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", areaName=" + areaName + ", hotelName=" + hotelName + ", address=" + address
				+ ", neareatStation=" + neareatStation + ", price=" + price + ", parking=" + parking + "]";
	}

}
