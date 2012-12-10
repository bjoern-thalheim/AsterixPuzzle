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

}
