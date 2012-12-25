package de.bjoernthalheim.asterixpuzzle.deck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.elements.Figure;
import de.bjoernthalheim.asterixpuzzle.elements.Half;
import de.bjoernthalheim.asterixpuzzle.elements.Orientation;

/**
 * Testcase for {@link CardImpl}. The only relevant logic in there is the instantiation strategy.
 * 
 * @author bjoern
 * 
 */
public class CardImplTest {

	/**
	 * Test instantiation from spec String.
	 */
	@Test
	public void testInstantiation() {
		Card card;
		{ // when
			// Characters need to be intepreted case-insensitive.
			card = new CardImpl("AtObmBlT");
		}
		{ // then
			assertEquals(Figure.ASTERIX, card.getEdge(Orientation.NORTH).getFigure());
			assertEquals(Figure.OBELIX, card.getEdge(Orientation.EAST).getFigure());
			assertEquals(Figure.MIRACULIX, card.getEdge(Orientation.SOUTH).getFigure());
			assertEquals(Figure.LEGIONAIRE, card.getEdge(Orientation.WEST).getFigure());
			assertEquals(Half.TOP, card.getEdge(Orientation.NORTH).getHalf());
			assertEquals(Half.BOTTOM, card.getEdge(Orientation.EAST).getHalf());
			assertEquals(Half.BOTTOM, card.getEdge(Orientation.SOUTH).getHalf());
			assertEquals(Half.TOP, card.getEdge(Orientation.WEST).getHalf());
		}
	}

}
