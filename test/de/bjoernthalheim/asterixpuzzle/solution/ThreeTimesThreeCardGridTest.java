package de.bjoernthalheim.asterixpuzzle.solution;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;

public class ThreeTimesThreeCardGridTest {

	private ThreeTimesThreeCardGrid grid;
	
	@Before
	public void setup() {
		this.grid = new ThreeTimesThreeCardGrid();
	}
	
	@Test
	public void testDefensiveCopy() {
		Card card = new CardImpl("atmtatat");
		grid.putOntoNextFreePositionSuccessful(card , Orientation.NORTH);
		Card card2 = new CardImpl("otototmb");
		grid.putOntoNextFreePositionSuccessful(card2, Orientation.NORTH);
		grid.defensiveCopy();
	}
	
	@Test
	public void testFindIsomorphicGrid() {
		ThreeTimesThreeCardGrid grid1 = new ThreeTimesThreeCardGrid();
		CardImpl cornerCard = new CardImpl("ATABOTOB");
		grid1.putOntoNextFreePositionSuccessful(cornerCard, Orientation.NORTH);
		ThreeTimesThreeCardGrid grid2 = new ThreeTimesThreeCardGrid();
		grid2.putOntoNextFreePositionSuccessful(CardImpl.NOTHING, Orientation.NORTH);
		grid2.putOntoNextFreePositionSuccessful(CardImpl.NOTHING, Orientation.NORTH);
		grid2.putOntoNextFreePositionSuccessful(cornerCard, Orientation.EAST);
		assertTrue(grid1.isIsomorphic(grid2));
	}

}
