package com.abstractart.museum.models;

import com.abstractart.museum.abstracts.Art;

public class Painting extends Art {
	
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		// TODO Auto-generated constructor stub
		
		this.setPaintType(paintType);
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		String result = "";
		result += "Title: " + getTitle() + "\n";
		result += "Author: " + getAuthor() + "\n";
		result += "Description: " + getDescription() + "\n";
		result += "Paint Type: " + getPaintType() + "\n";
		
		System.out.println(result);
		
	}
	
	

	
	
	

}
