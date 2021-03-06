package de.bjoernthalheim.asterixpuzzle.grids;

import de.bjoernthalheim.asterixpuzzle.deck.DisplayableCard;

public interface DisplayableCardGrid extends CardGrid {

	/**
	 * Get the desired Card at the given index.
	 * 
	 * @param x horizontal coordinate.
	 * @param y vertical coordinate.
	 * @return The card at this position.
	 */
	DisplayableCard getCardAt(int x, int y);
}
