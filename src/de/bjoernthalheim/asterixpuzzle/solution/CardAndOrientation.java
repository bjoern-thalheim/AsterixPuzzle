package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.deck.FigureAndHalf;

public class CardAndOrientation {

	public static final CardAndOrientation NOTHING = new CardAndOrientation(CardImpl.NOTHING, Orientation.NORTH);

	private final Card card;

	private final Orientation rotation;

	public CardAndOrientation(Card theCard, Orientation theOrientation) {
		this.card = theCard;
		this.rotation = theOrientation;
	}

	public Card getCard() {
		return card;
	}

	public Orientation getOrientation() {
		return rotation;
	}

	public FigureAndHalf getEdge(Orientation orientation) {
		return card.getEdge(orientation.rotate(rotation));
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Orientation orientation : Orientation.values()) {
			FigureAndHalf edge = card.getEdge(orientation.rotate(rotation));
			result.append(edge.toShortString());
		}
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((card == null) ? 0 : card.hashCode());
		result = prime * result + ((rotation == null) ? 0 : rotation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardAndOrientation other = (CardAndOrientation) obj;
		if (card == null) {
			if (other.card != null)
				return false;
		}
		// not it is made sure both objects are valid instances of their classes, we can go into comparing them without
		// being afraid of a NullPointerException.
		return this.isIsomorphic(other);
	}

	private boolean isIsomorphic(CardAndOrientation other) {
		for (Orientation orientation : Orientation.values()) {
			if (!this.getEdge(orientation).equals(other.getEdge(orientation))) {
				return false;
			}
		}
		// No conflicts found.
		return true;
	}

}
