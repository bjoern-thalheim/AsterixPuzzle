package de.bjoernthalheim.asterixpuzzle.deck;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.deck.DisplayableCardImpl;
import de.bjoernthalheim.asterixpuzzle.elements.Orientation;

public class DisplayableCardImplTest {

	private DisplayableCardImpl card;
	
	private String imagePath = "asdfghjkl";

	@Before
	public void setup() {
		this.card = new DisplayableCardImpl("abotmblt");
		this.card.setImagePath(imagePath);
	}

	@Test
	public void testDisplayableCardImplCardOrientation() {
		DisplayableCardImpl clone = new DisplayableCardImpl(card);
		assertTrue(clone.equals(card));
	}

	@Test
	public void testCloneWithOrientation() {
		DisplayableCardImpl clone = new DisplayableCardImpl(card, Orientation.EAST);
		assertFalse(clone.equals(card));
		DisplayableCardImpl expectedClone = new DisplayableCardImpl("ltabotmb");
		assertEquals(expectedClone, clone);
	}

	@Test
	public void testTransitivity() {
		DisplayableCardImpl clone1 = new DisplayableCardImpl(card, Orientation.EAST);
		DisplayableCardImpl clone2 = new DisplayableCardImpl(clone1, Orientation.WEST);
		assertEquals(card, clone2);
	}

	@Test
	public void testAccumulateOrientations() {
		DisplayableCardImpl clone1 = new DisplayableCardImpl(card, Orientation.EAST);
		assertEquals(Orientation.EAST, clone1.getOrientation());
		DisplayableCardImpl clone2 = new DisplayableCardImpl(clone1, Orientation.EAST);
		assertEquals(Orientation.SOUTH, clone2.getOrientation());
	}
	
	@Test
	public void testRetainImagePath() {
		DisplayableCardImpl clone = new DisplayableCardImpl(card);
		assertEquals(clone.getImagePath(), card.getImagePath());
	}
	
	@Test
	public void testRetainImagePathWithOrientation() {
		DisplayableCardImpl clone = new DisplayableCardImpl(card, Orientation.SOUTH);
		assertEquals(clone.getImagePath(), card.getImagePath());
	}
}
