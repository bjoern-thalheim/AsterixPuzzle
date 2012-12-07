package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.Arrays;
import java.util.Collections;
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
		Deck deck = new DeckCreator().createNewDeck();
		CardGrid grid = new ThreeTimesThreeCardGrid();
		List<Solution> allSolutions = impl.findAllSolutions(deck, grid);
		for (Solution solution : allSolutions) {
			System.out.println(solution);
		}
	}

	/**
	 * Recursion - take a partially filled grid, a nonempty deck. Take a card from the deck and try to fit it into the next
	 * empty slot on the grid. If the card fits, recurse further. If not, return an empty list.
	 */
	@Override
	public List<Solution> findAllSolutions(Deck deck, CardGrid grid) {
		// FIXME There should be an addAll() in here, shouldn't it?
		for (Card card : deck.getCards()) {
			deck.take(card);
			Orientation[] orientations = Orientation.values();
			for (Orientation orientation : orientations) {
				if (grid.put(card, orientation)) {
					if (deck.isEmpty()) {
						Solution solution = new SolutionImpl(grid);
						return Collections.singletonList(solution);
					}
					return findAllSolutions(deck, grid);
				}
			}
		}
		return Collections.emptyList();
	}

}
