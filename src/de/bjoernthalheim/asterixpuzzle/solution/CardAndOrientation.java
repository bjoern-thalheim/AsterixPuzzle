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
}
