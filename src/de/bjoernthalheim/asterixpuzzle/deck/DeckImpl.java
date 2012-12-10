package de.bjoernthalheim.asterixpuzzle.deck;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for a deck of cards.
 * 
 * @author bjoern
 */
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
	 * @param card
	 *            The card which will be added.
	 */
	public void addCard(Card card) {
		CardImpl defensiveCopy = new CardImpl(card);
		this.cards.add(defensiveCopy);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.bjoernthalheim.asterixpuzzle.deck.Deck#getCards()
	 */
	@Override
	public List<Card> getCards() {
		ArrayList<Card> defensiveCopy = new ArrayList<Card>(cards);
		return defensiveCopy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.bjoernthalheim.asterixpuzzle.deck.Deck#take(de.bjoernthalheim.asterixpuzzle.deck.Card)
	 */
	@Override
	public void take(Card card) {
		if (!cards.remove(card)) {
			throw new IllegalArgumentException("Card " + card + " is not on this deck, so it can't be taken off");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see de.bjoernthalheim.asterixpuzzle.deck.Deck#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}

	@Override
	public void putBack(Card card) {
		this.cards.add(card);
	}

	@Override
	public Deck defensiveCopy() {
		Deck deck = new DeckImpl();
		for (Card card : this.cards) {
			deck.addCard(card);
		}
		return deck;
	}
	
	@Override
	public String toString() {
		return this.cards.size() + " " + this.cards.toString();
	}
}
