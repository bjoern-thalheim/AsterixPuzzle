package de.bjoernthalheim.asterixpuzzle.deck;

import de.bjoernthalheim.asterixpuzzle.Orientation;

public interface Card {

	/**
	 * Find out what is depicted on the given side of the card.
	 * 
	 * @param orientation The orientation of the desired edge (one of the four edges)
	 * @return The Figure and the Half of that side of the card.
	 */
	public FigureAndHalf getEdge(Orientation orientation);
}
