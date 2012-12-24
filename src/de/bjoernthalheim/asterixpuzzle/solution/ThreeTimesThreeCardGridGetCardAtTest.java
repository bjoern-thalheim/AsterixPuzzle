package de.bjoernthalheim.asterixpuzzle.solution;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;

public class ThreeTimesThreeCardGridGetCardAtTest {

	/**
	 * Class under Test.
	 */
	ThreeTimesThreeCardGrid grid;
	
	/**
	 * Init class under test.
	 */
	@Before
	public void setup() {
		this.grid = new ThreeTimesThreeCardGrid();
	}
	
	/**
	 * This test case is important because x and y can be easily mixed up.
	 */
	@Test
	public void testGetCardAt() {
		Card card1 = new CardImpl("atatatat");
		this.grid.putOntoNextFreePositionSuccessful(card1, Orientation.NORTH);
		Card card2 = new CardImpl("abababab");
		this.grid.putOntoNextFreePositionSuccessful(card2, Orientation.NORTH);
		Card card3 = new CardImpl("atatatat");
		this.grid.putOntoNextFreePositionSuccessful(card3, Orientation.NORTH);
		Card card4 = new CardImpl("abababab");
		this.grid.putOntoNextFreePositionSuccessful(card4, Orientation.NORTH);
		assertEquals(card1, grid.getCardAt(0, 0));
		assertEquals(card2, grid.getCardAt(1, 0));
		assertEquals(card3, grid.getCardAt(2, 0));
		assertEquals(card4, grid.getCardAt(0, 1));
	}

}
