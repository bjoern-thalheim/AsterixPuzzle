package de.bjoernthalheim.asterixpuzzle;

import java.util.List;

import de.bjoernthalheim.asterixpuzzle.deck.Deck;

public interface SolutionFinder {

	public List<Solution> findAllSolutions(Deck deck, CardGrid grid);
}
