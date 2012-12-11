package de.bjoernthalheim.asterixpuzzle.solution;

import java.util.List;

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

	/**
	 * Create a copy of this grid.
	 * 
	 * @return A copy of this grid.
	 */
	CardGrid defensiveCopy();

	/**
	 * Tell if all blank spaces in the grid have been filled.
	 * 
	 * @return <code>true</code> if all blank spaces have been filled - this means we found a solution.
	 */
	boolean isFull();

	/**
	 * Provide the current grid cards.
	 * 
	 * @return the current state of the grid.
	 */
	List<PositionAndOrientationAndCard> getCards();

}
