package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.strategy.DisplayableCard;

public class DisplayableCardImpl extends CardImpl implements DisplayableCard {

	private String imagePath;
	private Orientation orientation;

	public DisplayableCardImpl(Card card) {
		super(card);
	}

	public DisplayableCardImpl(Card card, Orientation orientation) {
		super(card, orientation);
		recalculateOrientation(card, orientation);
	}

	private void recalculateOrientation(Card card, Orientation orientation) {
		this.orientation = orientation;
	}

	public DisplayableCardImpl(String spec) {
		super(spec);
	}

	@Override
	public String getImagePath() {
		return this.imagePath;
	}

	@Override
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	

}
