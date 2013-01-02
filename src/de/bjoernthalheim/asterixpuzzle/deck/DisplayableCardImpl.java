package de.bjoernthalheim.asterixpuzzle.deck;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.elements.Orientation;

public class DisplayableCardImpl extends CardImpl implements DisplayableCard {

	/**
	 * Neutral orientation is NORTH.
	 */
	private Orientation orientation = Orientation.NORTH;

	public DisplayableCardImpl(String spec) {
		super(spec);
	}

	public DisplayableCardImpl(Card card) {
		super(card);
		if (card instanceof DisplayableCard) {
			this.setImagePath(((DisplayableCard) card).getImagePath());
		}
	}

	public DisplayableCardImpl(Card card, Orientation newOrientation) {
		super(card, newOrientation);
		if (card instanceof DisplayableCard) {
			this.orientation = ((DisplayableCard) card).getOrientation();
			this.imagePath = ((DisplayableCard) card).getImagePath();
		}
		recalculateOrientation(newOrientation);
	}

	private void recalculateOrientation(Orientation orientation) {
		this.orientation = this.orientation.plus(orientation);
	}

	private String imagePath;

	@Override
	public String getImagePath() {
		return this.imagePath;
	}

	@Override
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public Orientation getOrientation() {
		return orientation;
	}
}
