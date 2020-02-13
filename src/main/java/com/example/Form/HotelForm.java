package com.example.Form;

/**
 * ホテル検索時に使うフォームクラスです.
 * 
 * @author rinashioda
 *
 */
public class HotelForm {

	/** 価格 */
	private String price;

	public int getIntPrice() {
		return Integer.parseInt(price);
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelForm [price=" + price + "]";
	}

}
