package de.bjoernthalheim.asterixpuzzle.deck;

import de.bjoernthalheim.asterixpuzzle.elements.Orientation;

public interface DisplayableCard extends Card {

	String getImagePath();
	
	void setImagePath(String ImagePath);

	Orientation getOrientation();

}
