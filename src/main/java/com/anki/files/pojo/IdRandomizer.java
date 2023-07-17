package com.anki.files.pojo;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;



public class IdRandomizer {
	
	
	private int Randomizer(ArrayList<decks> ids) {
		int index=(int)Math.random()*ids.size();	
		return index;
	}
}
