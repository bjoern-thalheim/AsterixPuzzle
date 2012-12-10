package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;
import de.bjoernthalheim.asterixpuzzle.solution.Solution;
import de.bjoernthalheim.asterixpuzzle.solution.SolutionImpl;
import de.bjoernthalheim.asterixpuzzle.solution.ThreeTimesThreeCardGrid;

public class BrutForceSolutionFinderImpl implements SolutionFinder {

	/**
	 * Recursion start. Take the full deck and an empty grid and pass that into the recursion.
	 * 
	 * @param args
	 *            ignored.
	 */
	public static void main(String[] args) {
		BrutForceSolutionFinderImpl impl = new BrutForceSolutionFinderImpl();
		// init deck, grid and empty solution list.
		Deck deck = new DeckCreator().createNewDeck();
		CardGrid grid = new ThreeTimesThreeCardGrid();
		List<Solution> allSolutions = new ArrayList<Solution>();
		// recursion start.
		try {
			// FIXME - the rotation of the cards needs to be put into the recursion as well to recurse better!
			impl.findAllSolutions(allSolutions, deck, grid);
		} finally {
			// Solution presentation.
			System.out.println(allSolutions.size() + " solutions found: ");
			for (Solution solution : allSolutions) {
				System.out.println(solution);
			}
		}
	}

	/**
	 * Recursion - take a partially filled grid, a nonempty deck. Take a card from the deck and try to fit it into the next
	 * empty slot on the grid. If the card fits, recurse further. If not, return an empty list.
	 */
	@Override
	public void findAllSolutions(List<Solution> solutions, Deck deck, CardGrid grid) {
		for (Card card : deck.getCards()) {
			deck.take(card);
			if (!cardFitsIntoNextPosition(solutions, deck, grid, card)) {
				deck.putBack(card);
			}
			deck.putBack(card);
		}
	}

	private boolean cardFitsIntoNextPosition(List<Solution> solutions, Deck deck, CardGrid grid, Card card) {
		boolean cardFitsAnyhow = false;
		for (Orientation orientation : Orientation.values()) {
			cardFitsAnyhow |= fitCardWithPosition(solutions, deck, grid, card, orientation);
		}
		return cardFitsAnyhow;
	}

	private boolean fitCardWithPosition(List<Solution> solutions, Deck deck, CardGrid grid, Card card,
			Orientation orientation) {
		if (grid.putOntoNextFreePositionSuccessful(card, orientation)) {
			recurseOrRegisterSolution(solutions, deck, grid);
			return deck.isEmpty();
		}
		return false;
	}

	private void recurseOrRegisterSolution(List<Solution> solutions, Deck deck, CardGrid grid) {
		if (deck.isEmpty()) {
			Solution solution = new SolutionImpl(grid);
			solutions.add(solution);
		} else {
			// recurse
			findAllSolutions(solutions, deck.defensiveCopy(), grid.defensiveCopy());
		}
	}

}
