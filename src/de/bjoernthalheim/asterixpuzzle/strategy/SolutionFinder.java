package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Solution;

public interface SolutionFinder {

	void findAllSolutions(List<Solution> solutions, Deck deck, CardGrid grid);

	/**
	 * Once Solutions are found, all solutions which differ only in the rotation of cards or rotation of the whole grid need to be found and only one of them retained.
	 * 
	 * @param solutions The solution list which contains isomorphic solutions.
	 * @return The solutions without any duplicates.
	 */
	List<Solution> removeIsomorphicSolutions(List<Solution> solutions);
}
