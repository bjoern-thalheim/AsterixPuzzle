package de.bjoernthalheim.asterixpuzzle.strategy;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

public interface DisplayableCard extends Card {

	String getImagePath();
	
	void setImagePath(String ImagePath);

	Orientation getOrientation();

}
