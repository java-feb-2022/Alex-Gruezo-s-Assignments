package com.abstractart.museum.models;

import com.abstractart.museum.abstracts.Art;

public class Sculpture extends Art{

	private String material;

	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		// TODO Auto-generated constructor stub
		
		this.setMaterial(material);
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		String result = "";
		result += "Title: " + getTitle() + "\n";
		result += "Author: " + getAuthor() + "\n";
		result += "Description: " + getDescription() + "\n";
		result += "Material: " + getMaterial() + "\n";
		
		System.out.println(result);
		
	}
	
	
}
