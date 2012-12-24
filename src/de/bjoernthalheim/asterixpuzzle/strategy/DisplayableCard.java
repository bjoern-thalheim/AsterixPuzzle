package de.bjoernthalheim.asterixpuzzle.strategy;

import de.bjoernthalheim.asterixpuzzle.deck.Card;

public interface DisplayableCard extends Card {

	String getImagePath();
	
	void setImagePath(String ImagePath);

}
