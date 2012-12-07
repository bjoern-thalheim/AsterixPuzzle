package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;

/**
 * A Grid consisting of three times three cards.
 * 
 * @author bjoern
 */
public class ThreeTimesThreeCardGrid implements CardGrid {

	/*
	 * (non-Javadoc)
	 * @see de.bjoernthalheim.asterixpuzzle.solution.CardGrid#put(de.bjoernthalheim.asterixpuzzle.deck.Card, de.bjoernthalheim.asterixpuzzle.solution.Orientation)
	 */
	@Override
	public boolean putOntoNextFreePositionSuccessful(Card card, Orientation orientation) {
		return false;
	}

}
