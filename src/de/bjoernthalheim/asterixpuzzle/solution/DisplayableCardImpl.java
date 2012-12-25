package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.strategy.DisplayableCard;

public class DisplayableCardImpl extends CardImpl implements DisplayableCard {

	private String imagePath;

	/**
	 * Neutral orientation is NORTH.
	 */
	private Orientation orientation = Orientation.NORTH;

	public DisplayableCardImpl(Card card) {
		super(card);
		if (card instanceof DisplayableCard) {
			this.setImagePath(((DisplayableCard) card).getImagePath());
		}
	}

	public DisplayableCardImpl(Card card, Orientation newOrientation) {
		super(card, newOrientation);
		if (card instanceof DisplayableCardImpl) {
			this.orientation = ((DisplayableCardImpl) card).getOrientation();
		}
		if (card instanceof DisplayableCard) {
			this.setImagePath(((DisplayableCard) card).getImagePath());
		}
		recalculateOrientation(newOrientation);
	}

	private void recalculateOrientation(Orientation orientation) {
		this.orientation = this.orientation.plus(orientation);
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

	@Override
	public Orientation getOrientation() {
		return orientation;
	}
}
