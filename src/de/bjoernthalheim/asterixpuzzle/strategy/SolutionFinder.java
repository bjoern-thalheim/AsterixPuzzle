package de.bjoernthalheim.asterixpuzzle.strategy;

import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.solution.CardGrid;
import de.bjoernthalheim.asterixpuzzle.solution.Solution;

public interface SolutionFinder {

	void findAllSolutions(List<Solution> solutions, Deck deck, CardGrid grid);
}
