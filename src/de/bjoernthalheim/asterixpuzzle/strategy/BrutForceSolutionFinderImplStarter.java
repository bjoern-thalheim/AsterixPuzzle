package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Solution;
import de.bjoernthalheim.asterixpuzzle.solution.ThreeTimesThreeCardGrid;

public class BrutForceSolutionFinderImplStarter {

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
		impl.findAllSolutions(allSolutions, deck, grid);
		// Solution presentation.
		System.out.println(allSolutions.size() + " solutions found: ");
		for (Solution solution : allSolutions) {
			System.out.println(solution);
		}
	}

}
