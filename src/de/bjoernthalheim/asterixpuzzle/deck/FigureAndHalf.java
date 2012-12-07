package de.bjoernthalheim.asterixpuzzle.deck;

import java.io.Serializable;

/**
 * Compound enum representing the edge of a card.
 * 
 * @author bjoern
 */
public class FigureAndHalf implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Figure figure;
	private final Half half;

	public FigureAndHalf(Figure theFigure, Half theHalf) {
		this.figure = theFigure;
		this.half = theHalf;
	}

	public Figure getFigure() {
		return this.figure;
	}
	
	public Half getHalf() {
		return this.half;
	}

	@Override
	public String toString() {
		return "FigureAndHalf [figure=" + figure + ", half=" + half + "]";
	}
}
