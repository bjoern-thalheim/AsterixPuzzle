package de.bjoernthalheim.asterixpuzzle.solution;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;

/**
 * Test that the rotation of a card can be done well.
 * 
 * @author bjoern
 */
public class CardAndOrientationTest {

	/**
	 * The card which shall be used as the base of our test.
	 */
	private Card card;

	/**
	 * Init a Card.
	 */
	@Before
	public void setup() {
		this.card = new CardImpl("atobmtlb");
	}

	/**
	 * Test an unrotated Card.
	 */
	@Test
	public void testNoRotation() {
		CardAndOrientation cardAndOrientation = new CardAndOrientation(card, Orientation.NORTH);
		assertEquals(card.getEdge(Orientation.NORTH), cardAndOrientation.getEdge(Orientation.NORTH));
		assertEquals(card.getEdge(Orientation.EAST), cardAndOrientation.getEdge(Orientation.EAST));
		assertEquals(card.getEdge(Orientation.SOUTH), cardAndOrientation.getEdge(Orientation.SOUTH));
		assertEquals(card.getEdge(Orientation.WEST), cardAndOrientation.getEdge(Orientation.WEST));
	}

	/**
	 * Test Rotation by one quarter clockwise.
	 */
	@Test
	public void testRotateEast() {
		CardAndOrientation cardAndOrientation = new CardAndOrientation(card, Orientation.EAST);
		assertEquals(card.getEdge(Orientation.NORTH), cardAndOrientation.getEdge(Orientation.EAST));
		assertEquals(card.getEdge(Orientation.EAST), cardAndOrientation.getEdge(Orientation.SOUTH));
		assertEquals(card.getEdge(Orientation.SOUTH), cardAndOrientation.getEdge(Orientation.WEST));
		assertEquals(card.getEdge(Orientation.WEST), cardAndOrientation.getEdge(Orientation.NORTH));
	}

	/**
	 * Test Rotation by one half clockwise.
	 */
	@Test
	public void testRotateSouth() {
		CardAndOrientation cardAndOrientation = new CardAndOrientation(card, Orientation.SOUTH);
		assertEquals(card.getEdge(Orientation.WEST), cardAndOrientation.getEdge(Orientation.EAST));
		assertEquals(card.getEdge(Orientation.EAST), cardAndOrientation.getEdge(Orientation.WEST));
		assertEquals(card.getEdge(Orientation.NORTH), cardAndOrientation.getEdge(Orientation.SOUTH));
		assertEquals(card.getEdge(Orientation.SOUTH), cardAndOrientation.getEdge(Orientation.NORTH));
	}

	/**
	 * Test Rotation by three quarter clockwise.
	 */
	@Test
	public void testRotateWest() {
		CardAndOrientation cardAndOrientation = new CardAndOrientation(card, Orientation.WEST);
		assertEquals(card.getEdge(Orientation.NORTH), cardAndOrientation.getEdge(Orientation.WEST));
		assertEquals(card.getEdge(Orientation.EAST), cardAndOrientation.getEdge(Orientation.NORTH));
		assertEquals(card.getEdge(Orientation.SOUTH), cardAndOrientation.getEdge(Orientation.EAST));
		assertEquals(card.getEdge(Orientation.WEST), cardAndOrientation.getEdge(Orientation.SOUTH));
	}

}
