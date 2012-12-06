package de.bjoernthalheim.asterixpuzzle.strategy;

import de.bjoernthalheim.asterixpuzzle.deck.Card;
import de.bjoernthalheim.asterixpuzzle.deck.CardImpl;
import de.bjoernthalheim.asterixpuzzle.deck.Deck;
import de.bjoernthalheim.asterixpuzzle.deck.DeckImpl;

public class DeckCreator {

	/**
	 * Creates the deck depicted in allCards.jpg.
	 * 
	 * @return The Deck of cards.
	 */
	public Deck createNewDeck() {
		Deck result = new DeckImpl();
		Card card1 = new CardImpl("abmtotob");
		result.addCard(card1);
		return result;
	}
}
