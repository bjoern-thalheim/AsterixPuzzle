package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

public class BruteForceSolutionFinderImpl implements SolutionFinder {

	/**
	 * Recursion - take a partially filled grid, a nonempty deck. Take a card from the deck and try to fit it into the next
	 * empty slot on the grid. If the card fits, recurse further. If not, return an empty list.
	 */
	@Override
	public <T extends CardGrid> void findAllSolutions(List<T> solutions, Deck deck, T grid) {
		for (Card card : deck.getCards()) {
			Deck deckCopy = deck.defensiveCopy();
			deckCopy.take(card);
			for (Orientation orientation : Orientation.values()) {
				T gridCopy = grid.defensiveCopy();
				if (gridCopy.putOntoNextFreePositionSuccessful(card, orientation)) {
					if (gridCopy.isFull()) {
						solutions.add(gridCopy);
					} else {
						findAllSolutions(solutions, deckCopy, gridCopy);
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends CardGrid> List<T> removeIsomorphicSolutions(List<T> solutions) {
		List<CardGrid> result = new ArrayList<CardGrid>();
		for (CardGrid solution : solutions) {
			if (!containsIsomorphicSolutions(result, solution)) {
				result.add(solution);
			}
		}
		return (List<T>) result;
	}

	private boolean containsIsomorphicSolutions(List<CardGrid> result, CardGrid solutionToInsert) {
		for (CardGrid solution : result) {
			if (solution.isIsomorphic(solutionToInsert)) {
				return true;
			}
		}
		// no conflicts found
		return false;
	}
}
