package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;
import de.bjoernthalheim.asterixpuzzle.solution.Solution;
import de.bjoernthalheim.asterixpuzzle.solution.SolutionImpl;

public class BrutForceSolutionFinderImpl implements SolutionFinder {

	/**
	 * Recursion - take a partially filled grid, a nonempty deck. Take a card from the deck and try to fit it into the next
	 * empty slot on the grid. If the card fits, recurse further. If not, return an empty list.
	 */
	@Override
	public void findAllSolutions(List<Solution> solutions, Deck deck, CardGrid grid) {
		for (Card card : deck.getCards()) {
			Deck deckCopy = deck.defensiveCopy();
			deckCopy.take(card);
			for (Orientation orientation : Orientation.values()) {
				CardGrid gridCopy = grid.defensiveCopy();
				if (gridCopy.putOntoNextFreePositionSuccessful(card, orientation)) {
					if (gridCopy.isFull()) {
						solutions.add(new SolutionImpl(gridCopy));
					} else {
						findAllSolutions(solutions, deckCopy, gridCopy);
					}
				}
			}
		}
	}
}
