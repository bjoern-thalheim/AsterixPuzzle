package de.bjoernthalheim.asterixpuzzle.grids;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.deck.BlankCard;
import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.elements.Orientation;
import de.bjoernthalheim.asterixpuzzle.grids.ThreeTimesThreeCardGrid;

public class ThreeTimesThreeCardGridTest {

	private ThreeTimesThreeCardGrid grid;

	@Before
	public void setup() {
		this.grid = new ThreeTimesThreeCardGrid();
	}

	/**
	 * Since we are using {@link ThreeTimesThreeCardGrid#putOntoNextFreePositionSuccessful(Card, Orientation)} to create a defensive copy of an existing grid, and
	 * {@link ThreeTimesThreeCardGrid#putOntoNextFreePositionSuccessful(Card, Orientation)} validates that everything fits,
	 * {@link ThreeTimesThreeCardGrid#defensiveCopy()} could throw an exeption if something goes wrong.
	 */
	@Test
	public void testDefensiveCopy() {
		Card card = new CardImpl("atmtatat");
		grid.putOntoNextFreePositionSuccessful(card, Orientation.NORTH);
		Card card2 = new CardImpl("otototmb");
		grid.putOntoNextFreePositionSuccessful(card2, Orientation.NORTH);
		// a runtime exception would occur on the next statement of someting was wrong.
		grid.defensiveCopy();
	}

	@Test
	public void testFindIsomorphicGrid() {
		ThreeTimesThreeCardGrid grid1 = new ThreeTimesThreeCardGrid();
		CardImpl cornerCard = new CardImpl("ATABOTOB");
		grid1.putOntoNextFreePositionSuccessful(cornerCard, Orientation.NORTH);
		ThreeTimesThreeCardGrid grid2 = new ThreeTimesThreeCardGrid();
		grid2.putOntoNextFreePositionSuccessful(new BlankCard(), Orientation.NORTH);
		grid2.putOntoNextFreePositionSuccessful(new BlankCard(), Orientation.NORTH);
		grid2.putOntoNextFreePositionSuccessful(cornerCard, Orientation.EAST);
		assertTrue(grid1.isIsomorphic(grid2));
	}

	@Test
	public void testFindIsomorphicGridComplex() {
		// Grid 1:
		// [MTLTABOB, ATOTABLB, MTATMBOB ]
		// [ATLTMBOB, ATLTMBLB, MTOTABLB ]
		// [MTATOBLB, MTOTOBAB, ATMTLBOB ]
		ThreeTimesThreeCardGrid grid1 = new ThreeTimesThreeCardGrid();
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("MTLTABOB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("ATOTABLB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("MTATMBOB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("ATLTMBOB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("ATLTMBLB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("MTOTABLB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("MTATOBLB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("MTOTOBAB"), Orientation.NORTH));
		assertTrue(grid1.putOntoNextFreePositionSuccessful(new CardImpl("ATMTLBOB"), Orientation.NORTH));
		// Grid 2: (= Grid 1, rotated east)
		// [LBMTATOB, OBATLTMB, OBMTLTAB ]
		// [ABMTOTOB, LBATLTMB, LBATOTAB ]
		// [OBATMTLB, LBMTOTAB, OBMTATMB ]
		ThreeTimesThreeCardGrid grid2 = new ThreeTimesThreeCardGrid();
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("LBMTATOB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("OBATLTMB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("OBMTLTAB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("ABMTOTOB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("LBATLTMB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("LBATOTAB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("OBATMTLB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("LBMTOTAB"), Orientation.NORTH));
		assertTrue(grid2.putOntoNextFreePositionSuccessful(new CardImpl("OBMTATMB"), Orientation.NORTH));
		// Test Test on Isomophicness
		assertTrue(grid2.isIsomorphic(grid1));
		assertTrue(grid1.isIsomorphic(grid2));
	}

}
