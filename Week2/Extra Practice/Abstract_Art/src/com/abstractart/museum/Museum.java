package com.abstractart.museum;

import java.util.ArrayList;
import java.util.Collections;

import com.abstractart.museum.abstracts.Art;
import com.abstractart.museum.models.Painting;
import com.abstractart.museum.models.Sculpture;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Art> museum = new ArrayList<Art>();
		museum.add(new Painting("Paining 1", "Painter 1", "Description 1", "Paint Type 1"));
		museum.add(new Painting ("Painting 2", "Painter 2", "Description 2", "Paint Type 2"));
		museum.add(new Painting ("Painting 3", "Painter 3", "Description 3", "Paint Type 3"));
		museum.add(new Sculpture("Sculpture 1", "Sculptor 1", "Description 1", "Material 1"));
		museum.add(new Sculpture("Sculpture 2", "Sculptor 2", "Description 2", "Material 2"));
		
		Collections.shuffle(museum);
		
		for (Art pieces : museum) {
			pieces.viewArt();
		}
		
	}

}
