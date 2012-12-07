package de.bjoernthalheim.asterixpuzzle.solution;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.FigureAndHalf;

public class CardAndOrientation {

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
