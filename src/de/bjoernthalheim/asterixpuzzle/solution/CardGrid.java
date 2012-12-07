package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;

public interface CardGrid {

	/**
	 * Put a card into the next free position in the grid.
	 * 
	 * @param card
	 *            The card which shall be put onto the next free position of the grid.
	 * @param orientation
	 *            The orientation with which she card shall be inserted.
	 * @return If it is possible to insert the given card with the given orientation onto the next free position of the
	 *         grid.
	 */
	boolean putOntoNextFreePositionSuccessful(Card card, Orientation orientation);

}
