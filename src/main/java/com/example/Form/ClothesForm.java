package com.example.Form;

public class ClothesForm {
	
	private String gender;
	
	private String color;
	
	public int getIntGender() {
		return Integer.parseInt(gender);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ClothesForm [gender=" + gender + ", color=" + color + "]";
	}
	
	

}
