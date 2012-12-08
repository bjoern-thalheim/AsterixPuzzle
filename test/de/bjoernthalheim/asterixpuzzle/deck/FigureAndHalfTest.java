package de.bjoernthalheim.asterixpuzzle.deck;

import static org.junit.Assert.*;

import org.junit.Test;

public class FigureAndHalfTest {

	@Test
	public void testFitting() {
		FigureAndHalf item1 = new FigureAndHalf(Figure.ASTERIX, Half.BOTTOM);
		FigureAndHalf item2 = new FigureAndHalf(Figure.ASTERIX, Half.TOP);
		assertTrue(item1.fits(item2));
		assertTrue(item2.fits(item1));
	}

	@Test
	public void testSameHalf() {
		FigureAndHalf item1 = new FigureAndHalf(Figure.MIRACULIX, Half.BOTTOM);
		FigureAndHalf item2 = new FigureAndHalf(Figure.MIRACULIX, Half.BOTTOM);
		assertFalse(item1.fits(item2));
		assertFalse(item2.fits(item1));
	}

	@Test
	public void testDifferentFigure() {
		FigureAndHalf item1 = new FigureAndHalf(Figure.ASTERIX, Half.BOTTOM);
		FigureAndHalf item2 = new FigureAndHalf(Figure.OBELIX, Half.TOP);
		assertFalse(item1.fits(item2));
		assertFalse(item2.fits(item1));
	}

	/**
	 * As a null object, a {@link FigureAndHalf} has a neutral object, which always fits. This way, blank spaces in the
	 * grid and the border of the grid can be handled.
	 */
	@Test
	public void testNeutralObject() {
		FigureAndHalf item1 = new FigureAndHalf(Figure.ASTERIX, Half.BOTTOM);
		FigureAndHalf nullObject = FigureAndHalf.NOTHING;
		assertTrue(item1.fits(nullObject));
		assertTrue(nullObject.fits(item1));

	}

}
