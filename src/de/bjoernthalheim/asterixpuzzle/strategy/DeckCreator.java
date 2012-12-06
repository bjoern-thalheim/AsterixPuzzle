package de.bjoernthalheim.asterixpuzzle.strategy;

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
		addCardToDeck(result, "abmtotob");
		addCardToDeck(result, "lbatltmb");
		addCardToDeck(result, "obmtltab");
		addCardToDeck(result, "obatmtlb");
		addCardToDeck(result, "lbatotab");
		addCardToDeck(result, "lbatotab");
		addCardToDeck(result, "lbmtotab");
		addCardToDeck(result, "lbmtatob");
		addCardToDeck(result, "obmtatmb");
		addCardToDeck(result, "obatltmb");
		return result;
	}

	private void addCardToDeck(Deck result, String spec) {
		CardImpl card = new CardImpl(spec);
		result.addCard(card);
	}
}
