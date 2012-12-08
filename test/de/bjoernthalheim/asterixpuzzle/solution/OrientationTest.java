package de.bjoernthalheim.asterixpuzzle.solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrientationTest {

	@Test
	public void testOpposite() {
		assertEquals(Orientation.NORTH, Orientation.SOUTH.opposite());
		assertEquals(Orientation.EAST, Orientation.WEST.opposite());
		assertEquals(Orientation.SOUTH, Orientation.NORTH.opposite());
		assertEquals(Orientation.WEST, Orientation.EAST.opposite());
		assertEquals(Orientation.NORTH, Orientation.NORTH.opposite().opposite());
		assertEquals(Orientation.EAST, Orientation.EAST.opposite().opposite());
		assertEquals(Orientation.SOUTH, Orientation.SOUTH.opposite().opposite());
		assertEquals(Orientation.WEST, Orientation.WEST.opposite().opposite());
	}

}
