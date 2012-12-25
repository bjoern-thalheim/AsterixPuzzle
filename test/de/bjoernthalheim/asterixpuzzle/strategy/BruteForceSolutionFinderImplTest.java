package de.bjoernthalheim.asterixpuzzle.strategy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.deck.DeckImpl;
import de.bjoernthalheim.asterixpuzzle.grids.CardGrid;

public class BruteForceSolutionFinderImplTest {

	/**
	 * Class under Test.
	 */
	private BruteForceSolutionFinderImpl strategy;

	@Before
	public void setup() {
		this.strategy = new BruteForceSolutionFinderImpl();
	}

	@Test
	public void testFindAllSolutionsVerySimple() {
		CardGrid grid = new Test2By1Grid(this);
		Deck deck = new DeckImpl();
		deck.addCard(new CardImpl("atatatat"));
		deck.addCard(new CardImpl("abababab"));
		List<CardGrid> solutions = new ArrayList<CardGrid>(1);
		strategy.findAllSolutions(solutions, deck, grid);
		solutions = strategy.removeIsomorphicSolutions(solutions);
		assertEquals(grid.toString(), 1, solutions.size());
	}

	@Test
	public void testFindAllSolutionsNotSoSimple() {
		CardGrid grid = new Test2By1Grid(this);
		Deck deck = new DeckImpl();
		deck.addCard(new CardImpl("atmtmtmt"));
		deck.addCard(new CardImpl("abmtmtmt"));
		List<CardGrid> solutions = new ArrayList<CardGrid>(1);
		strategy.findAllSolutions(solutions, deck, grid);
		solutions = strategy.removeIsomorphicSolutions(solutions);
		assertEquals(1, solutions.size());
	}
}