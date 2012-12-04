package de.bjoernthalheim.asterixpuzzle.deck;

import java.io.Serializable;

/**
 * Compound enum representing the edge of a card.
 * 
 * @author bjoern
 */
public class FigureAndHalf implements Serializable {

	private static final long serialVersionUID = 1L;

	private Figure figure;
	private Half half;

	public Figure getFigure() {
		return this.figure;
	}
	
	public Half getHalf() {
		return this.half;
	}
}
