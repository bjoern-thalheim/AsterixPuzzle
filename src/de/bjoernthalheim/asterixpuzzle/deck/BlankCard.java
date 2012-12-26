package de.bjoernthalheim.asterixpuzzle.deck;

import de.bjoernthalheim.asterixpuzzle.elements.FigureAndHalf;
import de.bjoernthalheim.asterixpuzzle.elements.Orientation;

public class BlankCard extends DisplayableCardImpl {

	public BlankCard() {
		// What is written in here is necessary to satisfy the super constructor but otherwise of no relevance, since
		// #getEdge is overwritten here.
		super("abababab");
	}

	@Override
	public FigureAndHalf getEdge(Orientation orientation) {
		return FigureAndHalf.NOTHING;
	}

	@Override
	public String getImagePath() {
		return "";
	}
}
