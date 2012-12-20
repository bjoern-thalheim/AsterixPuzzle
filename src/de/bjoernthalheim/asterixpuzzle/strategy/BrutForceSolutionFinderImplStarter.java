package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.ArrayList;
import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
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
		List<CardGrid> allSolutions = new ArrayList<CardGrid>();
		// recursion start.
		impl.findAllSolutions(allSolutions, deck, grid);
		// find really distinct solutions
		List<CardGrid> solutions = impl.removeIsomorphicSolutions(allSolutions);
		// Solution presentation.
		System.out.println(solutions.size() + " solutions found: ");
		// As long as we don't have a graphical representation, we need to output this stuff somehow
		for (CardGrid solution : solutions) {
			System.out.println(solution);
		}
	}

}
