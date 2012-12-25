package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.grids.CardGrid;
import de.bjoernthalheim.asterixpuzzle.grids.DisplayableCardGrid;

public interface SolutionFinder {

	/**
	 * Recursion method for finding solutions.
	 * 
	 * @param solutions
	 *            A list of solutions which we have already found. Should be empty on start.
	 * @param deck
	 *            A Deck of the rest of the cards which shall be used to fill the grid. Should be full on start.
	 * @param grid
	 *            A grid which will be filled. Should be empty on start.
	 */
	<T extends CardGrid> void findAllSolutions(List<T> solutions, Deck deck, T grid);

	/**
	 * Once Solutions are found, all solutions which differ only in the rotation of cards or rotation of the whole grid
	 * need to be found and only one of them retained.
	 * 
	 * @param <T>
	 *            {@link CardGrid} or {@link DisplayableCardGrid}.
	 * 
	 * @param solutions
	 *            The solution list which contains isomorphic solutions.
	 * @return The solutions without any duplicates.
	 */
	<T extends CardGrid> List<T> removeIsomorphicSolutions(List<T> solutions);
}
