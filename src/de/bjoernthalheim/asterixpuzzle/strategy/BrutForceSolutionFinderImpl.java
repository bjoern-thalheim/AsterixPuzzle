package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

public class BrutForceSolutionFinderImpl implements SolutionFinder {

	/**
	 * Recursion - take a partially filled grid, a nonempty deck. Take a card from the deck and try to fit it into the next
	 * empty slot on the grid. If the card fits, recurse further. If not, return an empty list.
	 */
	@Override
	public void findAllSolutions(List<CardGrid> solutions, Deck deck, CardGrid grid) {
		for (Card card : deck.getCards()) {
			Deck deckCopy = deck.defensiveCopy();
			deckCopy.take(card);
			for (Orientation orientation : Orientation.values()) {
				CardGrid gridCopy = grid.defensiveCopy();
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

	@Override
	public List<CardGrid> removeIsomorphicSolutions(List<CardGrid> solutions) {
		List<CardGrid> result = new ArrayList<CardGrid>();
		for (CardGrid solution : solutions) {
			if (!containsIsomorphicSolutions(result, solution)) {
				result.add(solution);
			}
		}
		return result;
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
