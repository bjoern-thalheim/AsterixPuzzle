package de.bjoernthalheim.asterixpuzzle.deck;

import de.bjoernthalheim.asterixpuzzle.solution.DisplayableCardImpl;
import de.bjoernthalheim.asterixpuzzle.solution.Orientation;

public class BlankCard extends DisplayableCardImpl {

	public BlankCard(Card card) {
		super(card, Orientation.NORTH);
	}

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

	@Override
	public void setImagePath(String ImagePath) {
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
