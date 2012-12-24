package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;

public interface IndexableCardGrid extends CardGrid {

	/**
	 * Get the desired Card at the given index.
	 * 
	 * @param x horizontal coordinate.
	 * @param y vertical coordinate.
	 * @return The card at this position.
	 */
	Card getCardAt(int x, int y);
}
