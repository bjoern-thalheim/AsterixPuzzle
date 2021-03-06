package de.bjoernthalheim.asterixpuzzle.deck;

import java.util.List;

/**
 * The deck (a pile of) cards. You can put cards on the deck, take cards off and look at all cards of it.
 * 
 * @author bjoern
 */
public interface Deck {

	/**
	 * Show all the cards of the deck.
	 * 
	 * @return All cards of the deck.
	 */
	public List<Card> getCards();

	/**
	 * Add a card to the deck.
	 * 
	 * @param card
	 *            The card to be added to the deck.
	 */
	public void addCard(Card card);

	/**
	 * Take a card from the deck.
	 * 
	 * @param card
	 *            The card which will be taken from the deck.
	 */
	public void take(Card card);

	/**
	 * Create a clone of this deck.
	 * 
	 * @return a clone of this deck.
	 */
	public Deck defensiveCopy();
}
