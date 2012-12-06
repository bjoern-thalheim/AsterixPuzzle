package de.bjoernthalheim.asterixpuzzle.deck;

import java.util.ArrayList;
import java.util.List;

public class DeckImpl implements Deck {

	/**
	 * The cards in the deck.
	 */
	private final List<Card> cards;
	
	/**
	 * Instantiate the deck.
	 */
	public DeckImpl() {
		this.cards = new ArrayList<Card>(9);
	}
	
	/**
	 * Add a specific card to the deck.
	 * 
	 * @param card The card which will be added.
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/*
	 * (non-Javadoc)
	 * @see de.bjoernthalheim.asterixpuzzle.deck.Deck#getCards()
	 */
	@Override
	public List<Card> getCards() {
		return cards;
	}

}
