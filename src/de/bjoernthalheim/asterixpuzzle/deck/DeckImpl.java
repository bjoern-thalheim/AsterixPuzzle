package de.bjoernthalheim.asterixpuzzle.deck;

import java.util.ArrayList;
import java.util.List;

import de.bjoernthalheim.asterixpuzzle.solution.DisplayableCardImpl;

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
		DisplayableCardImpl defensiveCopy = new DisplayableCardImpl(card);
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
