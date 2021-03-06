package de.bjoernthalheim.asterixpuzzle.elements;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.bjoernthalheim.asterixpuzzle.elements.Orientation;

public class OrientationTest {

	@Test
	public void testOpposite() {
		assertEquals(Orientation.NORTH, Orientation.SOUTH.opposite());
		assertEquals(Orientation.EAST, Orientation.WEST.opposite());
		assertEquals(Orientation.SOUTH, Orientation.NORTH.opposite());
		assertEquals(Orientation.WEST, Orientation.EAST.opposite());
	}
	
	@Test
	public void testOppositeOpposite() {
		assertEquals(Orientation.NORTH, Orientation.NORTH.opposite().opposite());
		assertEquals(Orientation.EAST, Orientation.EAST.opposite().opposite());
		assertEquals(Orientation.SOUTH, Orientation.SOUTH.opposite().opposite());
		assertEquals(Orientation.WEST, Orientation.WEST.opposite().opposite());
	}
}
