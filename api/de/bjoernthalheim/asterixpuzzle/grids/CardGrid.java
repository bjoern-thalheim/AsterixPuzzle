package de.bjoernthalheim.asterixpuzzle.grids;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.elements.Orientation;

public interface CardGrid {

	/**
	 * Put a card into the next free position in the grid.
	 * @param <T>
	 * 
	 * @param card
	 *            The card which shall be put onto the next free position of the grid.
	 * @param orientation
	 *            The orientation with which she card shall be inserted.
	 * @return If it is possible to insert the given card with the given orientation onto the next free position of the
	 *         grid.
	 */
	<T extends Card> boolean putOntoNextFreePositionSuccessful(T card, Orientation orientation);

	/**
	 * Create a copy of this grid.
	 * @param <T>
	 * 
	 * @return A copy of this grid.
	 */
	<T extends CardGrid> T defensiveCopy();

	/**
	 * Tell if all blank spaces in the grid have been filled.
	 * 
	 * @return <code>true</code> if all blank spaces have been filled - this means we found a solution.
	 */
	boolean isFull();

	/**
	 * Tells if the given grid looks like this grid, except for rotation.
	 * 
	 * @param otherGrid
	 *            Another grid.
	 * @return <code>true</code> if this grid and the other grid look exactly the same.
	 */
	boolean isIsomorphic(CardGrid otherGrid);
}
