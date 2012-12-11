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
		Deck deckClone = deck.defensiveCopy();
		for (Card card : deckClone.getCards()) {
			deckClone.take(card);
			cardFitsIntoNextPosition(solutions, deckClone.defensiveCopy(), grid, card);
		}
	}

	private void cardFitsIntoNextPosition(List<Solution> solutions, Deck deck, CardGrid grid, Card card) {
		for (Orientation orientation : Orientation.values()) {
			fitCardWithPosition(solutions, deck, grid, card, orientation);
		}
	}

	private void fitCardWithPosition(List<Solution> solutions, Deck deck, CardGrid grid, Card card,
			Orientation orientation) {
		CardGrid gridClone = grid.defensiveCopy();
		if (gridClone.putOntoNextFreePositionSuccessful(card, orientation)) {
			recurseOrRegisterSolution(solutions, deck, gridClone);
		}
	}

	private void recurseOrRegisterSolution(List<Solution> solutions, Deck deck, CardGrid grid) {
		if (grid.isFull()) {
			Solution solution = new SolutionImpl(grid);
			solutions.add(solution);
		} else {
			// recurse
			findAllSolutions(solutions, deck, grid);
		}
	}

}
